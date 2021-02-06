package com.oblair.nea.application.request;

import java.sql.Date;

import javax.persistence.Basic;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.oblair.nea.application.domain.DayCount;
import com.oblair.nea.application.domain.Frequency;

public class PriceRequest {

    @NotBlank
    private String isin;
    
    @NotBlank
    private String currency;

    @NotNull
    private Double coupon;

    @NotNull
    private Frequency frequency;
    
    @NotNull
    private DayCount dayCount;

    @NotNull
    @Basic
    private Date issueDate;

    @NotNull
    @Basic
    private Date maturityDate;

    @Basic
    private Date stubStartDate;

    @Basic
    private Date stubEndDate;

    @NotNull
    @Basic
    private Date valuationDate;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCoupon() {
        return coupon;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public DayCount getDayCount() {
        return dayCount;
    }

    public void setDayCount(DayCount dayCount) {
        this.dayCount = dayCount;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getStubStartDate() {
        return stubStartDate;
    }

    public void setStubStartDate(Date stubStartDate) {
        this.stubStartDate = stubStartDate;
    }

    public Date getStubEndDate() {
        return stubEndDate;
    }

    public void setStubEndDate(Date stubEndDate) {
        this.stubEndDate = stubEndDate;
    }

    public Date getValuationDate() {
        return valuationDate;
    }

    public void setValuationDate(Date valuationDate) {
        this.valuationDate = valuationDate;
    }

}
