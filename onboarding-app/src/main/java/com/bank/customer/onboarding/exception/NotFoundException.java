package com.bank.customer.onboarding.exception;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String user) {
        super(String.format("Account Overview not found for user : [%s]", user));
    }
}
