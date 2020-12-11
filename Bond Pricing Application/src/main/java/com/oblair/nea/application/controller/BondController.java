package com.oblair.nea.application.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.oblair.nea.application.repository.BondRepository;
import com.oblair.nea.application.repository.CurveRepository;
import com.oblair.nea.application.repository.UserRepository;
import com.oblair.nea.application.request.BondRequest;
import com.oblair.nea.application.response.ApiResponse;
import com.oblair.nea.application.response.BondResponse;
import com.oblair.nea.application.response.PagedResponse;
import com.oblair.nea.application.security.CurrentUser;
import com.oblair.nea.application.security.UserAuthority;
import com.oblair.nea.application.service.BondService;

@RestController
@RequestMapping("/api/bonds")
public class BondController {

    @Autowired
    private BondRepository bondRepository;

    @Autowired
    private CurveRepository curveRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BondService bondService;

    private static final Logger logger = LoggerFactory.getLogger(BondController.class);

    @GetMapping
    public PagedResponse<BondResponse> getPolls(@CurrentUser UserAuthority currentUser,
                                                @RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "30") int size) {
        return bondService.getAllBonds(currentUser, page, size);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createBond(@Valid @RequestBody BondRequest bondRequest) {
        Bond bond = bondService.createBond(bondRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{bondId}").buildAndExpand(bond.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Bond Created Successfully"));
    }

    @GetMapping("/{bondId}")
    public BondResponse getPollById(@CurrentUser UserAuthority currentUser,
                                    @PathVariable Long bondId) {
        return bondService.getBondById(bondId, currentUser);
    }

}