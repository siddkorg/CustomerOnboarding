package com.bank.customer.onboarding.validator;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.exception.BusinessValidationException;
import com.bank.customer.onboarding.exception.InvalidInputException;
import com.bank.customer.onboarding.model.login.Login;
import com.bank.customer.onboarding.model.onboarding.OnboardingRequestDetails;
import com.bank.customer.onboarding.validate.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author siddharthkorgaonkar
 * 21/06/2023
 */
@SpringBootTest(classes = {Validator.class})
public class ValidatorTest {

    @MockBean
    ApplicaitonProperties properties;
    @Autowired
    private Validator validator;

    @Test
    public void test_login_input_test() {
        Login login = new Login("username", "password");
        Login login1 = new Login("username", null);
        validator.validateLoginInputs(login);
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            validator.validateLoginInputs(login1);
        });
        assertTrue(exception.getLocalizedMessage().contains("logon"));
    }

    @Test
    public void test_onboarding_input_test() {

        when(properties.getMinimumAge()).thenReturn(18);
        when(properties.getWhiteListedCountries()).thenReturn("NL,BE,DE");
        when(properties.getValidEmailPattern()).thenReturn("^(.+)@(.+)$");

        OnboardingRequestDetails request = OnboardingRequestDetails.builder()
                .postCode(null).houseNo("34").familyName("jackson").initials("SD").build();
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            validator.validateOnboardingDetails(request);
        });
        assertTrue(exception.getLocalizedMessage().contains("onboarding"));


        request.setPostCode("1234PC");
        request.setGender("L");

        Exception genderException = assertThrows(InvalidInputException.class, () -> {
            validator.validateOnboardingDetails(request);
        });
        assertTrue(genderException.getLocalizedMessage().contains("onboarding"));


        request.setGender("M");
        request.setDob("2022-04-04");

        Exception ageException = assertThrows(BusinessValidationException.class, () -> {
            validator.validateOnboardingDetails(request);
        });
        assertTrue(ageException.getLocalizedMessage().contains("AGE_VALIDATION"));


        request.setDob("2000-04-04");
        request.setCountry("IN");

        Exception countryException = assertThrows(BusinessValidationException.class, () -> {
            validator.validateOnboardingDetails(request);
        });
        assertTrue(countryException.getLocalizedMessage().contains("COUNTRY_VALIDATION"));


        request.setCountry("BE");
        request.setEmail(".");
        Exception emailException = assertThrows(InvalidInputException.class, () -> {
            validator.validateOnboardingDetails(request);
        });
        assertTrue(emailException.getLocalizedMessage().contains("onboarding"));
    }

}
