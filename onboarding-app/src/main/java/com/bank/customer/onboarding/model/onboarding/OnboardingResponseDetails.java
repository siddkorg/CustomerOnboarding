package com.bank.customer.onboarding.model.onboarding;

import lombok.Builder;
import lombok.Data;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
@Data
@Builder
public class OnboardingResponseDetails {

    private String username;
    private String password;
}
