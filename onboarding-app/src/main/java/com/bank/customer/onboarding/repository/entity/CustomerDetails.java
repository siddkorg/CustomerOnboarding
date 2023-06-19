package com.bank.customer.onboarding.repository.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Customer details.
 */
@Data
@Entity
@Table(name = "customer_details", schema="onboarding")
@RequiredArgsConstructor
public class CustomerDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	//Date of birth
	@Column(name = "dob")
	private String dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "country")
	private String country;

	@Column(name = "address")
	private String address;

	@Column(name = "account")
	private String account;

	@Column(name = "status")
	private String status;

	/**
	 * Instantiates a new Customer details.
	 *
	 * @param email    the email
	 * @param username the username
	 * @param age      the age
	 * @param gender   the gender
	 * @param country  the country
	 * @param address  the address
	 * @param account  the account
	 * @param status   the status
	 */
	public CustomerDetails( String email, String username, String  dob, String gender,String country, String address, String account, String status) {
		this.email = email;
		this.username = username;
		this.dob = dob;
		this.gender = gender;
		this.country = country;
		this.address = address;
		this.account = account;
		this.status = status;
	}

}
