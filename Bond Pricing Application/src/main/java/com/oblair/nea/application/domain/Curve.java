package com.oblair.nea.application.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(name = "Curve")
public class Curve extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    private InterpolationType type;

    @OneToMany(mappedBy = "curve", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    private List<CurvePoint> points = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CurvePoint> getPoints() {
        return points;
    }

    public void setPoints(List<CurvePoint> points) {
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
