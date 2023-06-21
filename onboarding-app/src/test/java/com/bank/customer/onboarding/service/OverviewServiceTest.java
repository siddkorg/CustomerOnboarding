package com.bank.customer.onboarding.service;

import com.bank.customer.onboarding.repository.CustomerAccountOverviewRepository;
import com.bank.customer.onboarding.repository.entity.CustomerAccountOverview;
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
@SpringBootTest(classes = {OverviewService.class})
public class OverviewServiceTest {

    @MockBean
    CustomerAccountOverviewRepository customerAccountOverviewRepository;
    @Autowired
    private OverviewService overviewService;

    @Test
    public void test_account_overview() {

        String username = "username";

        CustomerAccountOverview overview = new CustomerAccountOverview();
        overview.setCurrency("EUR");

        when(customerAccountOverviewRepository.findByUsername(username)).thenReturn(overview);

        assertEquals(overviewService.getCustomerAccountDetails(username).getCurrency(), "EUR");

    }
}
