package com.bank.customer.onboarding.repository;

import com.bank.customer.onboarding.repository.entity.CustomerAccountOverview;
import com.bank.customer.onboarding.repository.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
public interface CustomerAccountOverviewRepository extends JpaRepository<CustomerAccountOverview, Long> {

    CustomerAccountOverview findByUsername(String username);
}
