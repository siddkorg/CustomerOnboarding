package com.bank.customer.onboarding.repository.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The type Customer account overview.
 */
@Data
@Entity
@Table(name = "customer_account_overview", schema="onboarding")
@RequiredArgsConstructor
public class CustomerAccountOverview implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * Instantiates a new Customer account overview.
	 *
	 * @param username the username
	 * @param balance  the balance
	 * @param type     the type
	 * @param account  the account
	 * @param currency the currency
	 * @param datetime the datetime
	 */
	public CustomerAccountOverview(String username, double balance, String type, String account, String currency, Timestamp datetime) {
		this.username = username;
		this.balance = balance;
		this.type = type;
		this.account = account;
		this.currency = currency;
		this.datetime = datetime;
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

	/**
	 * The Datetime.
	 */
	@Column(name = "datetime", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp datetime;



}
