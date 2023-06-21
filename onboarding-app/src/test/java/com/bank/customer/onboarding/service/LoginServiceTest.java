package com.bank.customer.onboarding.service;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.model.login.Login;
import com.bank.customer.onboarding.repository.CustomerDetailsRepository;
import com.bank.customer.onboarding.repository.entity.CustomerDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author siddharthkorgaonkar
 * 20/06/2023
 */
@SpringBootTest(classes = {LoginService.class})
public class LoginServiceTest {

    @MockBean
    CustomerDetailsRepository customerDetailsRepository;
    @MockBean
    ApplicaitonProperties properties;
    @Autowired
    private LoginService loginService;

    @Test
    public void test_login_service() {

        Login login = new Login("username", "password");
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setUsername("sikorgao");

        when(properties.getPassword()).thenReturn("password");
        when(properties.getToken()).thenReturn("token123");
        when(customerDetailsRepository.findByUsername(login.getUsername())).thenReturn(customerDetails);

        assertEquals(loginService.authenticateUser(login).getToken(), "token123");

    }
}
