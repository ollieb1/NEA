package com.oblair.nea.application.response;

import java.util.List;

import com.oblair.nea.application.domain.Curve;

public class PriceResponse {
    
    private Curve curve;
    private List<CashFlow> cashFlows;
    double price;
    
    public Curve getCurve() {
        return curve;
    }
    public void setCurve(Curve curve) {
        this.curve = curve;
    }
    public List<CashFlow> getCashFlows() {
        return cashFlows;
    }
    public void setCashFlows(List<CashFlow> cashFlows) {
        this.cashFlows = cashFlows;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
