package com.bank.customer.onboarding.controller;

import com.bank.customer.onboarding.model.onboarding.OnboardingRequestDetails;
import com.bank.customer.onboarding.model.onboarding.OnboardingResponseDetails;
import com.bank.customer.onboarding.service.OnboardingService;
import com.bank.customer.onboarding.validate.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Onboarding controller.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegisterCustomerController {

    /**
     * The Onboarding service.
     */
    @Autowired
    OnboardingService onboardingService;

    /**
     * The Validator.
     */
    @Autowired
    Validator validator;

    /**
     * Onboard customer response entity.
     *
     * @param customerDetails the customer details
     * @return the response entity
     */
    @PostMapping("/register")
    public ResponseEntity<OnboardingResponseDetails> onboardCustomer(@RequestBody OnboardingRequestDetails customerDetails) {

        validator.validateOnboardingDetails(customerDetails);
        OnboardingResponseDetails onboardingResponseDetails =onboardingService.onboardCustomer(customerDetails);
        return new ResponseEntity<>(onboardingResponseDetails, HttpStatus.CREATED);
    }


}

