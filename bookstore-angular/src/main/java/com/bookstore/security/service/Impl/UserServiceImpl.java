package com.bookstore.security.service.Impl;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.Security.UserRole;
import com.bookstore.domain.model.User;
import com.bookstore.security.service.UserService;
import com.bookstore.security.userRepository.RoleRepository;
import com.bookstore.security.userRepository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
				
		User localUser = userRepository.findByUsername(user.getUsername());
		if(localUser!= null) {
			LOG.warn("User name already Exist , Nothing will be done " + user.getUsername());
		}else
		{
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
		user.getUserRoles().addAll(userRoles);
		localUser = userRepository.save(user);
		}
		
		return localUser;
	}

}
