package com.bank.customer.onboarding.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
@Component
@Data
public class ApplicaitonProperties {

    @Value("${onboarding.customer.dummy.password}")
    public String password ;

    @Value("${onboarding.business.validation.minimum.age}")
    public int minimumAge ;

    @Value("${onboarding.business.validation.allowed.countries}")
    public String whiteListedCountries ;

    @Value("${onboarding.business.validation.allowed.email.pattern}")
    public String validEmailPattern ;

    @Value("${onboarding.customer.dummy.token}")
    public String token ;


}
