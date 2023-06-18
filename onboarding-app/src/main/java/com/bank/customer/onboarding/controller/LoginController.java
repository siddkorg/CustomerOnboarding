package com.bank.customer.onboarding.controller;

import com.bank.customer.onboarding.model.login.Login;
import com.bank.customer.onboarding.model.login.LoginResponse;
import com.bank.customer.onboarding.service.LoginService;
import com.bank.customer.onboarding.validate.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Login controller.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    /**
     * The Login service.
     */
    @Autowired
    LoginService loginService;

    /**
     * The Validator.
     */
    @Autowired
    Validator validator;

    /**
     * Customer login response entity.
     *
     * @param login the login
     * @return the response entity
     */
    @PostMapping("/logon")
    public ResponseEntity<LoginResponse> customerLogin(@RequestBody Login login) {

        validator.validateLoginInputs(login);
        LoginResponse loginResponse = loginService.authenticateUser(login);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}
