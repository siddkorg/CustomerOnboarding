package com.bank.customer.onboarding.util;


/**
 * The enum Error code util.
 *
 * @author siddharthkorgaonkar  17/06/2023
 */
public enum ErrorCodeUtil {

    /**
     * The Unknown.
     */
    UNKNOWN("ERR_500", "Unknown error"),
    /**
     * The Invalid input.
     */
    INVALID_INPUT("ERR_000", "Invalid inputs, please validate all fields"),
    /**
     * The Unauthorized.
     */
    UNAUTHORIZED("ERR_001", "Customer is unauthorized to login"),
    /**
     * The Invalid age.
     */
    INVALID_AGE("ERR_002", "User can not register due to age restriction"),
    /**
     * The Invalid country.
     */
    INVALID_COUNTRY("ERR_003", "User can not register due to invalid country"),
    /**
     * The Overview not found.
     */
    OVERVIEW_NOT_FOUND("ERR_004", "Account-Overview not found for customer");

    private final String errorCode;
    private final String message;

    ErrorCodeUtil(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets error code.
     *
     * @return the error code
     */
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return errorCode + ": " + message;
    }
}
