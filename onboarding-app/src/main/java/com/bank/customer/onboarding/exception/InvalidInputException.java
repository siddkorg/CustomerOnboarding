package com.bank.customer.onboarding.exception;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String method) {
        super(String.format("Invalid inputs provided while calling: [%s]", method));
    }
}
