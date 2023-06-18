package com.bank.customer.onboarding.util;

import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * @author siddharthkorgaonkar
 * 17/06/2023
 */
@Component
public class OnboardingUtil {


    public static final String AGE_VALIDATION = "AGE_VALIDATION";
    public static final String COUNTRY_VALIDATION = "COUNTRY_VALIDATION";
    public static final String BANK_CODE = "XYZA";
    public static final String SEPARATOR = "_";
    public static final String CURRENCY = "EUR";
    public static final String ACCOUNT_TYPE = "saving";
    public static final Double BALANCE = 7563.87;



    public String getUniqueUserName(String familyName, String initials) {
        String currentTime = String.valueOf(System.currentTimeMillis());
        return new StringBuilder().append(familyName, 0, 2).append(initials, 0, 2).append(currentTime).substring(8);

    }

    public String createIBAN(String country) {
        return new StringBuilder().append(country)  // NL
                .append(10 + new Random().nextInt(90)) // 42
                .append(BANK_CODE)  // XYZZ
                .append(String.valueOf(System.currentTimeMillis()), 0, 10).toString(); // random 10 digit
    }

    public String getAddress(String houseNo, String postCode, String country) {
        return new StringBuilder().append(houseNo).append(SEPARATOR).append(postCode).append(SEPARATOR).append(country).toString();
    }
}
