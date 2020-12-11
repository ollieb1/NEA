package com.oblair.nea.application.request;

import javax.validation.constraints.NotNull;

public class CurvePointRequest {

    @NotNull  
    private Integer offset;
    
    @NotNull
    private Double rate;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }  
    
}
