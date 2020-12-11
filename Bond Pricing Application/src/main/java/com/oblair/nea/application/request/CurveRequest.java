package com.oblair.nea.application.request;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oblair.nea.application.domain.InterpolationType;

public class CurveRequest {

    @NotNull
    private Date curveDate;
    
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    private InterpolationType type;

    @NotNull
    private List<CurvePointRequest> points = new ArrayList<>();

    public Date getCurveDate() {
        return curveDate;
    }

    public void setCurveDate(Date curveDate) {
        this.curveDate = curveDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InterpolationType getType() {
        return type;
    }

    public void setType(InterpolationType type) {
        this.type = type;
    }

    public List<CurvePointRequest> getPoints() {
        return points;
    }

    public void setPoints(List<CurvePointRequest> points) {
        this.points = points;
    }

}
