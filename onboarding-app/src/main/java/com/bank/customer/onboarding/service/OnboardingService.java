package com.bank.customer.onboarding.service;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.exception.CustomerAlreadyExistException;
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
import org.springframework.util.StringUtils;

import java.sql.Timestamp;

import static com.bank.customer.onboarding.util.OnboardingUtil.*;


/**
 * The type Onboarding service.
 *
 * @author siddharthkorgaonkar 18/06/2023
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class OnboardingService {

    /**
     * The Customer details repository.
     */
    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    /**
     * The Overview repository.
     */
    @Autowired
    CustomerAccountOverviewRepository overviewRepository;

    /**
     * The Applicaiton properties.
     */
    @Autowired
    ApplicaitonProperties applicaitonProperties;

    /**
     * The Onboarding util.
     */
    @Autowired
    OnboardingUtil onboardingUtil;

    /**
     * Onboard customer onboarding response details.
     *
     * @param cust is representation of customer
     * @return the onboarding response details
     */
    public OnboardingResponseDetails onboardCustomer(OnboardingRequestDetails cust) {

        String username = onboardingUtil.getUniqueUserName(cust.getFamilyName(),cust.getInitials());
        String address  = onboardingUtil.getAddress(cust.getHouseNo(),cust.getPostCode(),cust.getCountry());
        String iban = onboardingUtil.createIBAN(cust.getCountry());
        String gender = StringUtils.hasText(cust.getGender())?cust.getGender():"NOT_PROVIDED";

        checkIfCustomerAlreadyExist(cust);

        // Save customer details
        CustomerDetails newCustomer = saveCustomerDetails(cust, username, address, iban, gender);

        // Save customer's account overview
        saveCustomerAccountOverview(username, iban);

        return OnboardingResponseDetails.builder().password(applicaitonProperties.getPassword()).username(newCustomer.getUsername()).build();
    }

    private void checkIfCustomerAlreadyExist(OnboardingRequestDetails cust) {
        CustomerDetails existingCustomer = customerDetailsRepository.findByEmail(cust.getEmail());
        if(null != existingCustomer){
            throw new CustomerAlreadyExistException(cust.getEmail());
        }
    }

    private void saveCustomerAccountOverview(String username, String iban) {

        CustomerAccountOverview overview = new CustomerAccountOverview(username,BALANCE,ACCOUNT_TYPE, iban, CURRENCY, new Timestamp(System.currentTimeMillis()));
        overviewRepository.save(overview);
        log.info("Customer Account-Overview created");
    }


    private CustomerDetails saveCustomerDetails(OnboardingRequestDetails cust, String username, String address, String iban, String gender) {

        CustomerDetails customer = new CustomerDetails(cust.getEmail(), username, cust.getDob(), gender, cust.getCountry(), address, iban,"ACTIVE");
        CustomerDetails  newCustomer = customerDetailsRepository.save(customer);
        log.info("Customer created with username [{}]", newCustomer.getUsername());
        return newCustomer;
    }
}
