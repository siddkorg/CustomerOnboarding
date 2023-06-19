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

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */

@Slf4j
@Component
public class Validator {


    @Autowired
    ApplicaitonProperties applicaitonProperties;

    String[] acceptedGenderValues = {"F", "O", "M"};

    public void validateLoginInputs(Login login){

        if(!StringUtils.hasText(login.getUsername()) || !StringUtils.hasText(login.getPassword())){
            throw new InvalidInputException("logon");
        }
       log.info("Validated login inputs");
    }



    public void validateOnboardingDetails(OnboardingRequestDetails c)  {

        if(!StringUtils.hasText(c.getInitials())  || !StringUtils.hasText(c.getFamilyName()) || !StringUtils.hasText(c.getHouseNo()) || !StringUtils.hasText(c.getPostCode())  ){
            log.error("Invalid name or address");
            throw new InvalidInputException("onboarding");
        }

        if(StringUtils.hasText(c.getGender()) && !(Arrays.asList(acceptedGenderValues).contains(c.getGender()))) {
            log.error("Invalid gender value [{}]",c.getGender());
            throw new InvalidInputException("onboarding");
        }

        if( (c.getAge() == 0) ||c.getAge()<applicaitonProperties.getMinimumAge() ){
            log.error("Invalid age");
            throw new BusinessValidationException(OnboardingUtil.AGE_VALIDATION);
        }

        if(!StringUtils.hasText(c.getCountry()) || !Arrays.asList(applicaitonProperties.getWhiteListedCountries().split(",")).contains(c.getCountry())){
            log.error("Invalid country");
            throw new BusinessValidationException(OnboardingUtil.COUNTRY_VALIDATION);
        }

        if(!StringUtils.hasText(c.getEmail()) ||  !Pattern.compile(applicaitonProperties.getValidEmailPattern()).matcher(c.getEmail()).matches() ){
            log.error("Invalid email");
            throw new InvalidInputException("onboarding");
        }

        log.info("Validated Onboarding details of user successfully..!");
    }
}
