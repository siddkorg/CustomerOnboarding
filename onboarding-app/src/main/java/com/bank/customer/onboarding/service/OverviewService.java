package com.bank.customer.onboarding.service;

import com.bank.customer.onboarding.exception.NotFoundException;
import com.bank.customer.onboarding.mapper.AccountOverviewMapper;
import com.bank.customer.onboarding.model.overview.OverviewResponseDetails;
import com.bank.customer.onboarding.repository.CustomerAccountOverviewRepository;
import com.bank.customer.onboarding.repository.entity.CustomerAccountOverview;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Overview service.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class OverviewService {

    /**
     * The Customer account overview repository.
     */
    @Autowired
    CustomerAccountOverviewRepository customerAccountOverviewRepository;

    /**
     * Gets customer account details.
     *
     * @param username the username
     * @return the customer account details
     */
    public OverviewResponseDetails getCustomerAccountDetails(String username) {

        CustomerAccountOverview customerAccountOverview = customerAccountOverviewRepository.findByUsername(username);
        if(null == customerAccountOverview){
            throw new NotFoundException(username);
        }
        return AccountOverviewMapper.MAPPER.toMAP(customerAccountOverview);
    }
}
