package com.bookstore.domain.Security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role implements Serializable {

	private static final long serialVersionUID=12341234L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int roleId;
	private String roleName;
	
	@OneToMany(mappedBy = "role" , cascade= CascadeType.ALL , fetch = FetchType.EAGER)
	Set<UserRole> userRoles =new HashSet<UserRole>();
	
	public Role() {}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	

	
}
