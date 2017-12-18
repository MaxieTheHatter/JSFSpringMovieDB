package com.maxie.manager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.maxie.dao.UserDAO;
import com.maxie.model.UserModel;

/**
 * CDI Bean for User objects
 * 
 * @author Maxie
 *
 */
@Named
public class UserManager {

	@Inject
	public UserDAO userDAO;

	/**
	 * Tells the DAO to add a new user to the database, executing an SQL INSERT
	 * query
	 * 
	 * @param model
	 *            the userModel containing the User ManagedBean
	 */
	public void addUser(UserModel model) {
		userDAO.addUser(model);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Executes the DAO method which returns a list of users from the database
	 * 
	 * @return List containing all entered users in the database
	 * @see UserDAO#getUsers()
	 */
	public List getUsers() {
		return userDAO.getUsers();
	}
}
