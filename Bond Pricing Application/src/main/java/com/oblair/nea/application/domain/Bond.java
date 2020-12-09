package com.oblair.nea.application.domain;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Bond")
public class Bond extends UserAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String isin;
    
    @NotBlank
    @Size(min = 3, max = 3)
    private String currency;

    @NotBlank
    private Double coupon;

    @NotBlank
    private Frequency frequency;
    
    @NotBlank 
    private DayCount dayCount;

    @NotNull
    @Basic
    private Date issueDate;

    @NotNull
    @Basic
    private Date maturityDate;

    @NotNull
    @Basic
    private Date stubStartDate;

    @NotNull
    @Basic
    private Date stubEndDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
