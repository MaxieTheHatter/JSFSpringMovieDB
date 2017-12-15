package com.maxie.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.maxie.model.UserModel;
import com.maxie.persistence.Role;
import com.maxie.persistence.User;

@Named
@Transactional("TransactionManager")
public class UserDAO {

	// inject the sessionFactory
	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * After user inputs are confirmed, receive created user and add to database, set's privileges to member by default
	 * @param model user to be added
	 */
	public void addUser(UserModel model) {
		User user = new User();
		user.setUsername(model.getUsername());
		user.setPwd(model.getPwd());
		// active the user account
		user.setEnabled(1);
		Role role = (Role) sessionFactory.getCurrentSession().createQuery("FROM role WHERE code='ROLE_USER'")
				.uniqueResult();
		if(role == null) {
			role = new Role();
			role.setCode("ROLE_USER");
			role.setLabel("STANDARD USER");
			sessionFactory.getCurrentSession().save(role);
		}
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		sessionFactory.getCurrentSession().save(user);
	}
}
