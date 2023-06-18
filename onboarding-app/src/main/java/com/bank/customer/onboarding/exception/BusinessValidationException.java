package com.bank.customer.onboarding.exception;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
public class BusinessValidationException extends RuntimeException {

    public BusinessValidationException(String businessValidation) {
        super(businessValidation);
    }
}
