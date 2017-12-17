package com.maxie.manager;

import javax.inject.Inject;
import javax.inject.Named;

import com.maxie.dao.UserDAO;
import com.maxie.model.UserModel;

/**
 * CDI Bean for User objects
 * @author Maxie
 *
 */
@Named
public class UserManager {

	@Inject
	public UserDAO userDAO;

	public void addUser(UserModel model) {
		userDAO.addUser(model);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
