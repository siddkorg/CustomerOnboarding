package com.bank.customer.onboarding.validator;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.exception.InvalidInputException;
import com.bank.customer.onboarding.model.login.Login;
import com.bank.customer.onboarding.model.onboarding.OnboardingRequestDetails;
import com.bank.customer.onboarding.validate.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author siddharthkorgaonkar
 * 19/06/2023
 */
@ExtendWith(MockitoExtension.class)
public class ValidatorTest {

    @InjectMocks
    Validator validator;

    @Mock
    ApplicaitonProperties applicaitonProperties;

    @BeforeEach
    public void setup() {
        when(applicaitonProperties.getValidEmailPattern()).thenReturn("^(.+)@(.+)$");
        when(applicaitonProperties.getMinimumAge()).thenReturn(18);
        when(applicaitonProperties.getWhiteListedCountries()).thenReturn("NL,DE,BE");
    }

    @Test
    public void test_login_input() {


        Login login = new Login("abc", null);

        Exception exception = assertThrows(InvalidInputException.class, () -> {
            validator.validateLoginInputs(login);
        });

        assertTrue(exception.getMessage().contains("[logon]"));

    }

    @Test
    public void test_register_input() {

        OnboardingRequestDetails details = new OnboardingRequestDetails("SD", "Korga", "abc@gmail.com", "2000-06-12", "M", "NL", "1212TR", "34-A");

        Exception exception = assertThrows(InvalidInputException.class, () -> {
            validator.validateOnboardingDetails(details);
        });

    }


}
