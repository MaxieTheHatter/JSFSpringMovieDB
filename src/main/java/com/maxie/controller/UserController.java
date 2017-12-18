package com.maxie.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.maxie.dao.UserDAO;
import com.maxie.manager.UserManager;
import com.maxie.model.UserModel;

/**
 * Controls the User ManagedBean
 * 
 * @author Maxie
 *
 */
@ManagedBean
@Named
public class UserController {

	// Inject UserManager bean
	@Inject
	public UserManager userManager;
	private UserModel model = new UserModel();

	/**
	 * Tries to register a new account, throws an error if the passwords don't match
	 * 
	 * @return redirects the user to the login page
	 */
	public String addUser() {
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
		// reset user variables
		model.reset();
		return "login";
	}

	/**
	 * Executes the getUsers method in the usermanager, which in turn does the same
	 * for the dao which accesses the database
	 * 
	 * @return List containing all the users in the database
	 * @see UserManager#getUsers()
	 * @see UserDAO#getUsers()
	 */
	public List getUsers() {
		return userManager.getUsers();
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
