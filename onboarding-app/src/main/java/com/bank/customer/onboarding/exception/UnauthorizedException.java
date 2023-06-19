package com.bank.customer.onboarding.exception;

/**
 * The type Unauthorized exception.
 *
 * @author siddharthkorgaonkar  17/06/2023
 */
public class UnauthorizedException extends RuntimeException{

    /**
     * Instantiates a new Unauthorized exception.
     *
     * @param user the user
     */
    public UnauthorizedException(String user) {
        super(String.format("Unauthorized user: [%s]", user));
    }
}
