package com.bank.customer.onboarding.repository;

import com.bank.customer.onboarding.repository.entity.CustomerAccountOverview;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Customer account overview repository.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
public interface CustomerAccountOverviewRepository extends JpaRepository<CustomerAccountOverview, Long> {

    /**
     * Find by username customer account overview.
     *
     * @param username the username
     * @return the customer account overview
     */
    CustomerAccountOverview findByUsername(String username);
}
