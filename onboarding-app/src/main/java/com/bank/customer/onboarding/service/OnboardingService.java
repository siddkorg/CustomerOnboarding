package com.bank.customer.onboarding.service;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.model.onboarding.OnboardingRequestDetails;
import com.bank.customer.onboarding.model.onboarding.OnboardingResponseDetails;
import com.bank.customer.onboarding.repository.CustomerAccountOverviewRepository;
import com.bank.customer.onboarding.repository.CustomerDetailsRepository;
import com.bank.customer.onboarding.repository.entity.CustomerAccountOverview;
import com.bank.customer.onboarding.repository.entity.CustomerDetails;
import com.bank.customer.onboarding.util.OnboardingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bank.customer.onboarding.util.OnboardingUtil.*;


/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class OnboardingService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    CustomerAccountOverviewRepository overviewRepository;

    @Autowired
    ApplicaitonProperties applicaitonProperties;

    @Autowired
    OnboardingUtil onboardingUtil;

    public OnboardingResponseDetails onboardCustomer(OnboardingRequestDetails customerDetails) {

        String username = onboardingUtil.getUniqueUserName(customerDetails.getFamilyName(),customerDetails.getInitials());
        String address  = onboardingUtil.getAddress(customerDetails.getHouseNo(),customerDetails.getPostCode(),customerDetails.getCountry());
        String IBAN = onboardingUtil.createIBAN(customerDetails.getCountry());

        // Save customer details
        CustomerDetails customer = new CustomerDetails(customerDetails.getEmail(),username, customerDetails.getAge(),customerDetails.getCountry(),address,IBAN,"ACTIVE");
        CustomerDetails  newCustomer =customerDetailsRepository.save(customer);
        log.info("Customer created with username [{}]", newCustomer.getUsername());

        // Save customer's account overview
        CustomerAccountOverview overview = new CustomerAccountOverview(username,BALANCE,ACCOUNT_TYPE,IBAN,CURRENCY);
        overviewRepository.save(overview);
        log.info("Customer Overview created");
        return OnboardingResponseDetails.builder().password(applicaitonProperties.getPassword()).username(newCustomer.getUsername()).build();
    }
}
