package com.niit.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Component
public class UsersDetail {
	@Id
	@GeneratedValue
	private int userId;
	private String role;
	@Transient
	private String errorCode;
	@Transient
	private String errorMessage;

	@Size(min = 3, max = 30, message = "Size can be between 3 and 30")
	@NotEmpty(message = "User full name can not be empty.")
	private String userFullName;

	@Size(min = 3, max = 30, message = "Username Size can be between 3 and 30")
	@NotEmpty(message = "UserName can not be empty.")
	@Column(unique = true)
	private String username;

	@NotEmpty(message = "Email can not be empty.")
	@Column(unique = true)
	private String userEmail;

	@NotEmpty(message = "Phone can not be empty.")
	@Column(unique = true)
	private String userPhone;

	@NotEmpty(message = "Password can not be empty.")
	private String password;

	private boolean enabled;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
