package com.bank.customer.onboarding.model.login;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Login.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@Data
@AllArgsConstructor
public class Login {
    private String username;
    private String password;

}
