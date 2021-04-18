package com.oblair.nea.application.controller;

import java.net.URI;
import java.sql.Date;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oblair.nea.application.domain.Curve;
import com.oblair.nea.application.exception.ResourceNotFoundException;
import com.oblair.nea.application.repository.CurveRepository;
import com.oblair.nea.application.response.ApiResponse;
import com.oblair.nea.application.response.PagedResponse;

@RestController
@RequestMapping("/api/curves")
public class CurveController {
//Contains APIs for curves.
    @Autowired
    private CurveRepository curveRepository;

    @GetMapping("/date/{curveDate}")
    public PagedResponse<Curve> getCurves(@PathVariable Date curveDate, @RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "30") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "name");
        Page<Curve> curves = curveRepository.findByCurveDate(curveDate, pageable);

        if(curves.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), curves.getNumber(),
                    curves.getSize(), curves.getTotalElements(), curves.getTotalPages(), curves.isLast());
        }

        return new PagedResponse<>(curves.getContent(), curves.getNumber(),
                curves.getSize(), curves.getTotalElements(), curves.getTotalPages(), curves.isLast());

    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createCurve(@Valid @RequestBody Curve curve) {
        //if user has ADMIN role creates curve 
        curve = curveRepository.save(curve);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{curveId}").buildAndExpand(curve.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Curve Created Successfully"));
    }

    @GetMapping("/{curveId}")
    @PreAuthorize("hasRole('USER')")
    public Curve getCurveById(@PathVariable Long curveId) {
        //returns curve if found if not exception thrown
        return curveRepository.findById(curveId).orElseThrow(() -> new ResourceNotFoundException("Curve", "id", curveId));
    }

}