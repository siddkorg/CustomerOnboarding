package com.bank.customer.onboarding.util;


/**
 * @author siddharthkorgaonkar
 * 17/06/2023
 */

public enum ErrorCodeUtil {

    UNKNOWN("ERR_500", "Unknown error"),
    INVALID_INPUT("ERR_000", "Invalid inputs, please validate all fields"),
    UNAUTHORIZED("ERR_001", "Customer is unauthorized to login"),
    INVALID_AGE("ERR_002", "User can not register due to age restriction"),
    INVALID_COUNTRY("ERR_003", "User can not register due to invalid country"),
    OVERVIEW_NOT_FOUND("ERR_004", "Account-Overview not found for customer");

    private final String errorCode;
    private final String message;

    ErrorCodeUtil(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return errorCode + ": " + message;
    }
}
