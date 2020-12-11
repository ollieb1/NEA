package com.oblair.nea.application.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.oblair.nea.application.domain.Bond;
import com.oblair.nea.application.exception.ResourceNotFoundException;
import com.oblair.nea.application.repository.BondRepository;
import com.oblair.nea.application.repository.CurveRepository;
import com.oblair.nea.application.repository.UserRepository;
import com.oblair.nea.application.request.BondRequest;
import com.oblair.nea.application.response.BondResponse;
import com.oblair.nea.application.response.PagedResponse;
import com.oblair.nea.application.security.UserAuthority;

@Service
public class BondService {

    private static final Logger logger = LoggerFactory.getLogger(BondService.class);
    
    @Autowired
    private BondRepository bondRepository;

    @Autowired
    private CurveRepository curveRepository;

    @Autowired
    private UserRepository userRepository;
    
    public PagedResponse<BondResponse> getAllBonds(UserAuthority currentUser, int page, int size) {

        // Retrieve Polls
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Bond> bonds = bondRepository.findAll(pageable);

        if(bonds.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), bonds.getNumber(),
                    bonds.getSize(), bonds.getTotalElements(), bonds.getTotalPages(), bonds.isLast());
        }

        // Map Bonds to BondResponses
        List<Long> bondIds = bonds.map(Bond::getId).getContent();

        List<BondResponse> bondResponses = bonds.map(bond -> {
            return mapBondToBondResponse(bond);
        }).getContent();

        return new PagedResponse<>(bondResponses, bonds.getNumber(),
                bonds.getSize(), bonds.getTotalElements(), bonds.getTotalPages(), bonds.isLast());
    }

    public Bond createBond(BondRequest bondRequest) {
        Bond bond = new Bond();
        return bondRepository.save(bond);
    }

    public BondResponse getBondById(Long bondId, UserAuthority currentUser) {

        Bond bond = bondRepository.findById(bondId).orElseThrow(
                () -> new ResourceNotFoundException("Bond", "id", bondId));


        return mapBondToBondResponse(bond);
    }

    public BondResponse mapBondToBondResponse(Bond bond) {
        BondResponse bondResponse = new BondResponse();
        return bondResponse;
    }
}