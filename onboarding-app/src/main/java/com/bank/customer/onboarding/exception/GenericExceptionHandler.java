package com.bank.customer.onboarding.exception;

import com.bank.customer.onboarding.model.ValidationResult;
import com.bank.customer.onboarding.util.ErrorCodeUtil;
import com.bank.customer.onboarding.util.OnboardingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Generic exception handler.
 *
 * @author siddharthkorgaonkar 17/06/2023
 */
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
@ComponentScan("com.bank.customer.onboarding.util")
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Unauthorized exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(value = {UnauthorizedException.class})
    protected ResponseEntity<ValidationResult> unauthorizedException(UnauthorizedException exception) {
        log.error("Exception: [{}]", exception.getMessage());
        ValidationResult validationResult = buildErrorResponse(ErrorCodeUtil.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(validationResult);
    }

    /**
     * Bad request response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(value = {InvalidInputException.class})
    protected ResponseEntity<ValidationResult> badRequest(InvalidInputException exception) {
        log.error("Exception: [{}]", exception.getMessage());
        ValidationResult validationResult = buildErrorResponse(ErrorCodeUtil.INVALID_INPUT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResult);
    }

    /**
     * Not found response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ValidationResult> notFound(NotFoundException exception) {
        log.error("Exception: [{}]", exception.getMessage());
        ValidationResult validationResult = buildErrorResponse(ErrorCodeUtil.OVERVIEW_NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validationResult);
    }

    /**
     * Not found response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(value = {CustomerAlreadyExistException.class})
    protected ResponseEntity<ValidationResult> notFound(CustomerAlreadyExistException exception) {
        log.error("Exception: [{}]", exception.getMessage());
        ValidationResult validationResult = buildErrorResponse(ErrorCodeUtil.CUSTOMER_ALREADY_EXIST);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(validationResult);
    }

    /**
     * Bad request response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(value = {BusinessValidationException.class})
    protected ResponseEntity<ValidationResult> badRequest(BusinessValidationException exception) {
        log.error("Exception due to business validation reason: [{}]", exception.getMessage());
        ErrorCodeUtil errorCodeUtil = ErrorCodeUtil.UNKNOWN;
        if (exception.getMessage().equals(OnboardingUtil.AGE_VALIDATION)) {
            errorCodeUtil = ErrorCodeUtil.INVALID_AGE;
        }
        if (exception.getMessage().equals(OnboardingUtil.COUNTRY_VALIDATION)) {
            errorCodeUtil = ErrorCodeUtil.INVALID_COUNTRY;
        }
        ValidationResult validationResult = buildErrorResponse(errorCodeUtil);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResult);
    }

    /**
     * Handle illegal state exception response entity.
     *
     * @param illegalStateException the illegal state exception
     * @return the response entity
     */
    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<Void> handleIllegalStateException(IllegalStateException illegalStateException) {
        log.error("An illegal state exception occurred", illegalStateException);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    private ValidationResult buildErrorResponse(ErrorCodeUtil errorCodeUtil) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setErrorCode(errorCodeUtil.getErrorCode());
        validationResult.setMessage(errorCodeUtil.getMessage());
        return validationResult;
    }
}
