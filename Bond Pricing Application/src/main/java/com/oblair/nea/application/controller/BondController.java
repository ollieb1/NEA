package com.oblair.nea.application.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.oblair.nea.application.domain.Bond;
import com.oblair.nea.application.domain.Curve;
import com.oblair.nea.application.exception.ResourceNotFoundException;
import com.oblair.nea.application.repository.BondRepository;
import com.oblair.nea.application.repository.CurveRepository;
import com.oblair.nea.application.request.PriceRequest;
import com.oblair.nea.application.response.ApiResponse;
import com.oblair.nea.application.response.PagedResponse;
import com.oblair.nea.application.response.PriceResponse;
import com.oblair.nea.application.service.BondService;

@RestController
@RequestMapping("/api/bonds")
public class BondController {
//Contains APIs for getting bonds, bond creation, pricing bond.
    @Autowired
    private BondRepository bondRepository;

    @Autowired
    private CurveRepository curveRepository;
    
    @Autowired
    private BondService bondService;

    private static final Logger logger = LoggerFactory.getLogger(BondController.class);

    @GetMapping
    public PagedResponse<Bond> getBonds(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "size", defaultValue = "30") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "isin");
        Page<Bond> bonds = bondRepository.findAll(pageable);

        if(bonds.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), bonds.getNumber(),
                    bonds.getSize(), bonds.getTotalElements(), bonds.getTotalPages(), bonds.isLast());
        }

        return new PagedResponse<>(bonds.getContent(), bonds.getNumber(),
                bonds.getSize(), bonds.getTotalElements(), bonds.getTotalPages(), bonds.isLast());

    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createBond(@Valid @RequestBody Bond bond) {
        
        bond = bondRepository.save(bond);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{bondId}").buildAndExpand(bond.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Bond Created Successfully"));
    }

    //gets the bond for a given bondId
    @GetMapping("/{bondId}")
    @PreAuthorize("hasRole('USER')")
    public Bond getBondById(@PathVariable Long bondId) {
        
        return bondRepository.findById(bondId).orElseThrow(() -> new ResourceNotFoundException("Bond", "id", bondId));
    }
    
    @PostMapping("/price")
    @PreAuthorize("hasRole('USER')")
    public PriceResponse priceBond(@Valid @RequestBody PriceRequest priceRequest) {
        
        Bond bond = getBondFromPriceRequest(priceRequest);
        
         //gets the curve for the corresponding currency and valuation date
        Curve curve = curveRepository.findByCurveDateAndCurrency(priceRequest.getValuationDate(), priceRequest.getCurrency()).orElseThrow(
                () -> new ResourceNotFoundException("Curve", "curveDate", priceRequest.getValuationDate(), "currency", priceRequest.getCurrency()));
        
        return bondService.price(bond, curve);
    }
    //gets the bond attributes from the client price request
    public Bond getBondFromPriceRequest(PriceRequest request) {
        Bond bond = new Bond();
        bond.setIsin(request.getIsin());
        bond.setCurrency(request.getCurrency());
        bond.setCoupon(request.getCoupon());
        bond.setFrequency(request.getFrequency());
        bond.setDayCount(request.getDayCount());
        bond.setIssueDate(request.getIssueDate());
        bond.setMaturityDate(request.getMaturityDate());
        bond.setStubStartDate(request.getStubStartDate());
        bond.setStubEndDate(request.getStubEndDate());
        return bond;
    }
}