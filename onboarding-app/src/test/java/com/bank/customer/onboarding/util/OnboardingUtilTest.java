package com.bank.customer.onboarding.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author siddharthkorgaonkar
 * 19/06/2023
 */
public class OnboardingUtilTest {

    private static Stream<Arguments> countryIbanSize() {
        return Stream.of(
                Arguments.of("NL", 18),
                Arguments.of("DE", 22),
                Arguments.of("BE", 16)
        );
    }

    private final OnboardingUtil onboardingUtil = new OnboardingUtil();

    @ParameterizedTest(name = "{index}: country:[{0}] => [{1}]")
    @MethodSource("countryIbanSize")
    void test_IBAN_creation(String country, int expectedIbanSize) {

        assertEquals(expectedIbanSize, onboardingUtil.createIBAN(country).length());

    }

    @Test
    void test_unique_name(){
        assertNotNull(onboardingUtil.getUniqueUserName("Korgaonakr","S.D"));
    }

    @Test
    void test_address(){
        assertEquals("45_1312WE_NL", onboardingUtil.getAddress("45","1312WE", "NL"));
    }
}
