package com.bank.customer.onboarding.service;

import com.bank.customer.onboarding.config.ApplicaitonProperties;
import com.bank.customer.onboarding.model.onboarding.OnboardingRequestDetails;
import com.bank.customer.onboarding.repository.CustomerAccountOverviewRepository;
import com.bank.customer.onboarding.repository.CustomerDetailsRepository;
import com.bank.customer.onboarding.util.OnboardingUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

/**
 * @author siddharthkorgaonkar
 * 20/06/2023
 */
@SpringBootTest(classes = {OnboardingService.class})
public class OnboardingServiceTest {

    @MockBean
    private OnboardingService onboardingService;

    @MockBean
    private OnboardingUtil onboardingUtil;

    @MockBean
    CustomerDetailsRepository customerDetailsRepository;

    @MockBean
    CustomerAccountOverviewRepository customerAccountOverviewRepository;

    @MockBean
    ApplicaitonProperties properties;

    @Test
    public void test_register_user(){

        OnboardingRequestDetails cust =  OnboardingRequestDetails.builder()
                .postCode("1181FG")
                .gender("M")
                .familyName("Sander")
                .initials("SD")
                .country("NL")
                .houseNo("98")
                .dob("2001-01-01")
                .email("sidd.korg@gmail.com").build();

        when(properties.getPassword()).thenReturn("password");
        when(properties.getToken()).thenReturn("token123");
        when(onboardingUtil.getUniqueUserName(cust.getFamilyName(),cust.getInitials())).thenReturn("username");
        when(onboardingUtil.getAddress(cust.getHouseNo(),cust.getPostCode(),cust.getCountry())).thenReturn("token123");
        when(onboardingUtil.createIBAN(cust.getCountry())).thenReturn("token123");
        when(customerDetailsRepository.findByEmail(cust.getEmail())).thenReturn(null);

        onboardingService.onboardCustomer(cust);
    }
}
