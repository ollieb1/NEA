package com.oblair.nea.application.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "Curve")
public class Curve extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Basic
    private Date curveDate;
    
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    @Size(min = 3, max = 3)
    private String currency;

    @NotNull
    private Frequency frequency;
 
    @NotNull
    private InterpolationType type;

//    @JsonManagedReference
    @OneToMany(mappedBy = "curve", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    private List<CurvePoint> points = new ArrayList<>();

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public InterpolationType getType() {
        return type;
    }

    public void setType(InterpolationType type) {
        this.type = type;
    }

    public List<CurvePoint> getPoints() {
        return points;
    }

    public void setPoints(List<CurvePoint> points) {
        points.stream().forEach(p -> p.setCurve(this));
        this.points = points;
    }
    
    public void addCurvePoint(CurvePoint point) {
        points.add(point);
        point.setCurve(this);
    }

    public void removeChoice(CurvePoint point) {
        points.remove(point);
        point.setCurve(null);
    }
}
