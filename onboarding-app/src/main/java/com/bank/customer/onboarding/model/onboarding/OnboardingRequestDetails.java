package com.bank.customer.onboarding.model.onboarding;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Onboarding request details.
 *
 * @author siddharthkorgaonkar 18/06/2023
 */
@Data
@AllArgsConstructor
public class OnboardingRequestDetails {

    private String initials;

    private String familyName;

    private String email;

    private String dob;

    private String gender;

    private String country;

    private String postCode;

    private String houseNo;


}
