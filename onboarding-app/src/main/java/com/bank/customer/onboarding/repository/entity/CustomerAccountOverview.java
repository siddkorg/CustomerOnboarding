package com.bank.customer.onboarding.repository.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "customer_account_overview", schema="onboarding")
@RequiredArgsConstructor
public class CustomerAccountOverview implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public CustomerAccountOverview(String username, double balance, String type, String account, String currency) {
		this.username = username;
		this.balance = balance;
		this.type = type;
		this.account = account;
		this.currency = currency;
	}

	@Column(name = "username")
	private String username;

	@Column(name = "balance")
	private double balance;

	@Column(name = "type")
	private String type;

	@Column(name = "account")
	private String account;

	@Column(name = "currency")
	private String currency;



}
