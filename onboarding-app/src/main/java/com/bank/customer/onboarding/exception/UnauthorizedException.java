package com.bank.customer.onboarding.exception;

/**
 * @author siddharthkorgaonkar
 * 17/06/2023
 */
public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String user) {
        super(String.format("Unauthorized user: [%s]", user));
    }
}
