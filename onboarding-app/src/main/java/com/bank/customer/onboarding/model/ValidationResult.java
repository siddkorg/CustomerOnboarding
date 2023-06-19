package com.bank.customer.onboarding.model;

import lombok.Data;

/**
 * The type Validation result.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@Data
public class ValidationResult {

    private String errorCode;
    private String message;
}
