package com.bank.customer.onboarding.model.login;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
