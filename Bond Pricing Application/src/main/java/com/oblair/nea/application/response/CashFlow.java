package com.oblair.nea.application.response;

import java.sql.Date;

public class CashFlow {
    
    private Date date;
    private double amount;
    private double discountedAmount;
    private double rate;
    private double discountFactor;
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getDiscountedAmount() {
        return discountedAmount;
    }
    public void setDiscountedAmount(double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getDiscountFactor() {
        return discountFactor;
    }
    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = discountFactor;
    }

}
