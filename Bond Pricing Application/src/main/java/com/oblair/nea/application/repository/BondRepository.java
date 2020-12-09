package com.oblair.nea.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oblair.nea.application.domain.Bond;

@Repository
public interface BondRepository extends JpaRepository<Bond, Long> {
    
    Optional<Bond> findById(Long bondId);

    List<Bond> findByIdIn(List<Long> bondIds);

    List<Bond> findByIdIn(List<Long> bondIds, Sort sort);
}