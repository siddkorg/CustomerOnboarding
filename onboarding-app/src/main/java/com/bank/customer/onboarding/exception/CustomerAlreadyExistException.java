package com.bank.customer.onboarding.exception;

/**
 * The type Customer already exist exception.
 *
 * @author siddharthkorgaonkar  19/06/2023
 */
public class CustomerAlreadyExistException extends RuntimeException  {

    /**
     * Instantiates a new Customer already exist exception.
     *
     * @param email the email
     */
    public CustomerAlreadyExistException(String email) {
        super(String.format("Customer already exist with email: [%s]", email));
    }
}
