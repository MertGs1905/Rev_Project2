package com.bluebarracuda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Registration")
public class Registration {

	@Id
	@Column(name="reg_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int regId;
	
	@Column(name="user_name", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", unique=true, nullable=false)
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param regId
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Registration(String username, String password, String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * @return the regId
	 */
	public int getRegId() {
		return regId;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setRegId(int regId) {
		this.regId = regId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Registration [regId=" + regId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}
