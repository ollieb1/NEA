package com.oblair.nea.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oblair.nea.application.domain.User;
import com.oblair.nea.application.exception.ResourceNotFoundException;
import com.oblair.nea.application.repository.BondRepository;
import com.oblair.nea.application.repository.CurveRepository;
import com.oblair.nea.application.repository.UserRepository;
import com.oblair.nea.application.response.BondResponse;
import com.oblair.nea.application.response.PagedResponse;
import com.oblair.nea.application.response.UserIdentityAvailability;
import com.oblair.nea.application.response.UserProfile;
import com.oblair.nea.application.response.UserSummary;
import com.oblair.nea.application.security.CurrentUser;
import com.oblair.nea.application.security.UserAuthority;
import com.oblair.nea.application.service.BondService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BondRepository bondRepository;

    @Autowired
    private CurveRepository curveRepository;
    
    @Autowired
    private BondService bondService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserAuthority currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());

        return userProfile;
    }

}