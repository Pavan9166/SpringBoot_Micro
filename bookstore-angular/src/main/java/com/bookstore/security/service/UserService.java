package com.bookstore.security.service;

import java.util.Set;

import com.bookstore.domain.Security.UserRole;
import com.bookstore.domain.model.User;


public interface UserService {

	User createUser(User user, Set<UserRole> userRoles);
	
}
