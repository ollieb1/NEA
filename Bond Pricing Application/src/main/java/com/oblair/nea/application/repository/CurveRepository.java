package com.oblair.nea.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oblair.nea.application.domain.Curve;

@Repository
public interface CurveRepository extends JpaRepository<Curve, Long> {
    
    Optional<Curve> findById(Long curveId);

    List<Curve> findByIdIn(List<Long> curveIds);
}