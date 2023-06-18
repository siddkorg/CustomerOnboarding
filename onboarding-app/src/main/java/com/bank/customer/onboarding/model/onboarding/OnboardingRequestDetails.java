package com.bank.customer.onboarding.model.onboarding;

import lombok.Data;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
@Data
public class OnboardingRequestDetails {

    private String initials;

    private String familyName;

    private String email;

    private int age;

    private String country;

    private String postCode;

    private String houseNo;


}
