package com.bank.customer.onboarding.exception;

/**
 * The type Not found exception.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
public class NotFoundException extends RuntimeException {

    /**
     * Instantiates a new Not found exception.
     *
     * @param user the user
     */
    public NotFoundException(String user) {
        super(String.format("Account Overview not found for user : [%s]", user));
    }
}
