package com.maxie.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.maxie.manager.UserManager;
import com.maxie.model.UserModel;

@ManagedBean
@Named
public class UserController {

	@Inject
	public UserManager userManager;
	private UserModel model = new UserModel();

	/**
	 * Tries to register a new account, throws an error if the passwords don't match
	 * @return redirects the user to the login page
	 */
	public String register() {
		try {
			if (!model.getPassword().equals(model.getConfirmPassword())) {
				throw new Exception("Both passwords must match");
			}
			userManager.addUser(model);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Registration failed, reason: " + e.getMessage(), ""));
			return null;
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration was successful", ""));
		// reset user variables
		model.reset();
		return "login";
	}

	// getters and setters
	public UserModel getModel() {
		return model;
	}

	public void setModel(UserModel model) {
		this.model = model;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
