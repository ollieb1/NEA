package com.oblair.nea.application.response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.oblair.nea.application.domain.InterpolationType;

public class CurveResponse {
    
    private Long id;

    private Date curveDate;
    
    private String name;

    private InterpolationType type;

    private List<CurvePointResponse> points = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<CurvePointResponse> getPoints() {
        return points;
    }

    public void setPoints(List<CurvePointResponse> points) {
        this.points = points;
    }

}
