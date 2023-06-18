package com.bank.customer.onboarding.model.overview;

import lombok.Data;

import java.io.Serializable;



/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
@Data
public class OverviewResponseDetails implements Serializable {

    private String accountNumber;
    private String accountType;
    private String currency;
    private Double balance;

}
