package com.maxie.model;

/**
 * Class used in registration of an account, takes a username and stores temporary variables for passwords
 * @author Maxie
 *
 */
public class UserModel {
	private String username;
	private String password;
	private String confirmPassword;

	/**
	 * Sets all variables to null when they're no longer needed
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
