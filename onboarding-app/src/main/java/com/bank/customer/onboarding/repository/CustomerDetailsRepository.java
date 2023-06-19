package com.bank.customer.onboarding.repository;

import com.bank.customer.onboarding.repository.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Customer details repository.
 *
 * @author siddharthkorgaonkar 18/06/2023
 */
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

    /**
     * Find by username customer details.
     *
     * @param username the username
     * @return the customer details
     */
    CustomerDetails findByUsername(String username);

    /**
     * Find by email customer details.
     *
     * @param email the email
     * @return the customer details
     */
    CustomerDetails findByEmail(String email);
}
