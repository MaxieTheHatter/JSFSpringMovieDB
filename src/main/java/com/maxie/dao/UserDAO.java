package com.maxie.dao;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.maxie.model.UserModel;
import com.maxie.persistence.Role;
import com.maxie.persistence.User;

/**
 * Data Access Object that handles database transaction for user objects.
 * Contains methods applying the CRUD standard
 * 
 * @author Maxie
 *
 */
@Named
@Transactional("transactionManager")
public class UserDAO {

	// inject the sessionFactory
	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * After user inputs are confirmed, receive created user and add to database,
	 * set's privileges to member by default. If user_role doesn't exist, add it to
	 * database.
	 * 
	 * @param model
	 *            user model retrieved from controller class
	 */
	public void addUser(UserModel model) {
		User user = new User();
		user.setUsername(model.getUsername());
		user.setPassword(model.getPassword());
		// active the user account
		user.setEnabled(1);
		Role role = (Role) sessionFactory.getCurrentSession().createQuery("FROM Role WHERE code='ROLE_USER'")
				.uniqueResult();
		if (role == null) {
			role = new Role();
			role.setCode("ROLE_USER");
			role.setLabel("STANDARD USER");
			sessionFactory.getCurrentSession().save(role);
		}
		user.setRole(role);
		sessionFactory.getCurrentSession().save(user);
	}
	
	public List getUsers() {
		return sessionFactory.openSession().createQuery("SELECT e.username, e.role_id FROM User").list();
	}

}
