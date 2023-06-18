package com.bank.customer.onboarding.service;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.exception.UnauthorizedException;
import com.bank.customer.onboarding.model.login.Login;
import com.bank.customer.onboarding.model.login.LoginResponse;
import com.bank.customer.onboarding.repository.CustomerDetailsRepository;
import com.bank.customer.onboarding.repository.entity.CustomerDetails;
import com.bank.customer.onboarding.util.OnboardingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    ApplicaitonProperties properties;

    public LoginResponse authenticateUser(Login login) {

        CustomerDetails customerDetails = customerDetailsRepository.findByUsername(login.getUsername());
        if (null == customerDetails || !login.getPassword().equals(properties.getPassword())) {
            throw new UnauthorizedException(login.getUsername());
        }
        log.info("Fetched user from database");
        LoginResponse loginResponse = new LoginResponse(properties.getToken());
        return loginResponse;
    }
}
