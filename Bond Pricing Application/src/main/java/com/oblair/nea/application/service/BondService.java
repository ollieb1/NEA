package com.oblair.nea.application.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.math4.analysis.UnivariateFunction;
import org.apache.commons.math4.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math4.analysis.interpolation.UnivariateInterpolator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.oblair.nea.application.domain.Bond;
import com.oblair.nea.application.domain.Curve;
import com.oblair.nea.application.domain.CurvePoint;
import com.oblair.nea.application.response.CashFlow;
import com.oblair.nea.application.response.PriceResponse;

@Service
public class BondService {

    private static final Logger logger = LoggerFactory.getLogger(BondService.class);

    public PriceResponse price(Bond bond, Curve curve) {

        LocalDate valuationDate = curve.getCurveDate().toLocalDate();
        LocalDate maturity = bond.getMaturityDate().toLocalDate();
        
        List<LocalDate> coupons = calculateCouponDates(bond, curve.getCurveDate().toLocalDate());

        double[] x = curve.getPoints().stream().mapToDouble(point -> point.getOffset()).toArray();
        double[] y = curve.getPoints().stream().mapToDouble(point -> point.getRate()).toArray();
        
        UnivariateInterpolator interpolator = new SplineInterpolator();
        UnivariateFunction function = interpolator.interpolate(x, y);

        List<CashFlow> cashflows = coupons.stream().map(date -> {

            double offset = ChronoUnit.DAYS.between(valuationDate, date);
            double rate = function.value(offset);

            CashFlow flow = new CashFlow();
            if (date.equals(maturity)) {
                flow.setAmount(100 + bond.getCoupon() / bond.getDivisor());
            } else {
                flow.setAmount(bond.getCoupon() / bond.getDivisor());
            }
            flow.setDate(Date.valueOf(date));
            flow.setRate(rate);
            flow.setDiscountFactor(Math.pow(1 + rate / bond.getDivisor(), -bond.getDivisor() * offset / 365));
            return flow;
            
        }).collect(Collectors.toList());
        double pv = cashflows.stream().mapToDouble(flow -> flow.getAmount() * flow.getDiscountFactor()).sum();
        
        PriceResponse response = new PriceResponse();
        response.setCurve(curve);
        response.setCashFlows(cashflows);
        response.setPrice(pv);
        
        return response;
    }

    private List<LocalDate> calculateCouponDates(Bond bond, LocalDate valuationDate) {
        
        LocalDate maturity = bond.getMaturityDate().toLocalDate();
        LocalDate issueDate = bond.getIssueDate().toLocalDate();
        if (valuationDate.isBefore(issueDate)) {
            valuationDate = issueDate;
        }
        
        Period intervalPeriod = Period.between(valuationDate, maturity);
        long totalMonths = intervalPeriod.toTotalMonths();
        
        long periods = 0;
        int step = 0;
        switch (bond.getFrequency()) {
        case QUARTERLY:
            periods = totalMonths % 3 == 0 && intervalPeriod.getDays() == 0 ? totalMonths / 3 - 1: totalMonths / 3;
            step = 3;
            break;
        case SEMIANNUALLY:
            periods = totalMonths % 6 == 0 && intervalPeriod.getDays() == 0 ? totalMonths / 6 - 1 : totalMonths / 6;
            step = 6;
            break;
        case ANNUALLY:
            periods = totalMonths % 12 == 0 && intervalPeriod.getDays() == 0 ? totalMonths / 12 - 1: totalMonths / 12;
            step = 12;
            break;
        }
        
        final int fstep = step;
        IntStream stream = IntStream.iterate((int)periods * step, i -> i - fstep).limit(periods);
        List<LocalDate> dates = stream.mapToObj(months -> maturity.minusMonths(months)).collect(Collectors.toList());
        dates.add(maturity);
        return dates;
    }
    
}