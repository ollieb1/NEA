package com.oblair.nea.application.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oblair.nea.application.domain.Curve;

@Repository
public interface CurveRepository extends JpaRepository<Curve, Long> {
    
    Optional<Curve> findById(Long curveId);
    
    Optional<Curve> findByCurveDateAndCurrency(Date curveDate, String currency);
    
    Page<Curve> findByCurveDate(Date curveDate, Pageable pageable);

    List<Curve> findByIdIn(List<Long> curveIds);
    
    List<Curve> findByIdIn(List<Long> curveIds, Sort sort);

}