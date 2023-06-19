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
        return new StringBuilder().append(familyName.substring(0,4)).append(initials, 0, 2).append(1111 + new Random().nextInt(9999)).toString().replaceAll("[^a-zA-Z0-9_-]", "0");
    }

    public String createIBAN(String country) {
        int totalLength = getOffset(country);
        return new StringBuilder().append(country)
                .append(10 + new Random().nextInt(90))
                .append(BANK_CODE)
                .append(System.currentTimeMillis())
                .append(System.currentTimeMillis()).substring(0,totalLength);
    }

    public String getAddress(String houseNo, String postCode, String country) {
        return new StringBuilder().append(houseNo).append(SEPARATOR).append(postCode).append(SEPARATOR).append(country).toString();
    }

    private int getOffset(String country) {
        if (country.equals("NL"))
            return 18;
        else if(country.equals("DE"))
            return 22;
        else if(country.equals("BE"))
            return 16;
        else
            return 0;
    }
}
