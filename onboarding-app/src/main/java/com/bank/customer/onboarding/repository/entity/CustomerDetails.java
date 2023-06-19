package com.bank.customer.onboarding.repository.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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

	@Column(name = "age")
	private int age;

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

	public CustomerDetails( String email, String username, int age, String gender,String country, String address, String account, String status) {
		this.email = email;
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.country = country;
		this.address = address;
		this.account = account;
		this.status = status;
	}

}
