package com.maxie.model;

/**
 * Class used in registration of an account, takes a username and stores temporary variables for passwords
 * @author Maxie
 *
 */
public class UserModel {
	private String username;
	private String pwd;
	private String pwdConfirm;

	/**
	 * Sets all variables to null when they're no longer needed
	 */
	public void reset() {
		this.username = null;
		this.pwd = null;
		this.pwdConfirm = null;
	}

	// Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdConfirm() {
		return pwdConfirm;
	}

	public void setPwdConfirm(String pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}
}
