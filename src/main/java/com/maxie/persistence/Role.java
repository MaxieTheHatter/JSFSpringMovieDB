package com.maxie.persistence;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * POJO for user roles used in hibernate mapping
 * 
 * @author Maxie
 *
 */
@Entity
public class Role {

	@Id
	@GeneratedValue
	private int roleId;
	private String code;
	private String label;
	// set of users used in oneToManyMapping
	@OneToMany(mappedBy = "role")
	private Set<User> users;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
