package com.maxie.model;

import javax.faces.bean.ManagedBean;

/**
 * ManagedBean for User objects
 * 
 * @author Maxie
 *
 */
@ManagedBean
public class UserModel {
	private String username;
	private String password;
	private String confirmPassword;

	/**
	 * resets the user bean by setting variables to null
	 */
	public void reset() {
		this.username = null;
		this.password = null;
		this.confirmPassword = null;
	}

	// Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
