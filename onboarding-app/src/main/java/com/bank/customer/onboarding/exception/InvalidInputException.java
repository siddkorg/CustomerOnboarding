package com.bank.customer.onboarding.exception;

/**
 * The type Invalid input exception.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
public class InvalidInputException extends RuntimeException {

    /**
     * Instantiates a new Invalid input exception.
     *
     * @param method the method
     */
    public InvalidInputException(String method) {
        super(String.format("Invalid inputs provided while calling: [%s]", method));
    }
}
