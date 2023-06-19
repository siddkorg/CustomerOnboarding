package com.bank.customer.onboarding.validate;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.exception.BusinessValidationException;
import com.bank.customer.onboarding.exception.InvalidInputException;
import com.bank.customer.onboarding.model.login.Login;
import com.bank.customer.onboarding.model.onboarding.OnboardingRequestDetails;
import com.bank.customer.onboarding.util.OnboardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * The type Validator.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@Slf4j
@Component
public class Validator {


    /**
     * The Applicaiton properties.
     */
    @Autowired
    ApplicaitonProperties applicaitonProperties;

    /**
     * The Accepted gender values.
     */
    String[] acceptedGenderValues = {"F", "O", "M"};

    /**
     * Validate login inputs.
     *
     * @param login the login
     */
    public void validateLoginInputs(Login login){

        if(!StringUtils.hasText(login.getUsername()) || !StringUtils.hasText(login.getPassword())){
            throw new InvalidInputException("logon");
        }
       log.info("Validated login inputs");
    }


    /**
     * Validate onboarding details.
     *
     * @param c is for OnboardingRequestDetails
     */
    public void validateOnboardingDetails(OnboardingRequestDetails c)  {

        String method = "onboarding";
        LocalDate date;
        Period period;
        LocalDate now =  LocalDate.now();

        if(!StringUtils.hasText(c.getInitials())  || !StringUtils.hasText(c.getFamilyName()) || !StringUtils.hasText(c.getHouseNo()) || !StringUtils.hasText(c.getPostCode())  ){
            log.error("Invalid name or address");
            throw new InvalidInputException(method);
        }

        if(StringUtils.hasText(c.getGender()) && !(Arrays.asList(acceptedGenderValues).contains(c.getGender()))) {
            log.error("Invalid gender value [{}]",c.getGender());
            throw new InvalidInputException(method);
        }

        try{
             date = LocalDate.parse(c.getDob());
             period = Period.between(date, now);
        }
        catch (Exception e){
            log.error("Invalid date of birth [{}]",c.getDob());
            throw new InvalidInputException(method);
        }

        if(!StringUtils.hasText(c.getDob()) || period.getYears() < applicaitonProperties.getMinimumAge() ){
            log.error("Customer not allowed due  age");
            throw new BusinessValidationException(OnboardingUtil.AGE_VALIDATION);
        }

        if(!StringUtils.hasText(c.getCountry()) || !Arrays.asList(applicaitonProperties.getWhiteListedCountries().split(",")).contains(c.getCountry())){
            log.error("Invalid country");
            throw new BusinessValidationException(OnboardingUtil.COUNTRY_VALIDATION);
        }

        if(!StringUtils.hasText(c.getEmail()) ||  !Pattern.compile(applicaitonProperties.getValidEmailPattern()).matcher(c.getEmail()).matches() ){
            log.error("Invalid email");
            throw new InvalidInputException(method);
        }

        log.info("Validated Onboarding details of user successfully..!");
    }
}
