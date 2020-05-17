package com.adminportal.service;

import java.util.List;
import java.util.Set;

import com.adminportal.domain.Book;
import com.adminportal.domain.User;
import com.adminportal.domain.security.UserRole;

public interface UserService {
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User findById(Long id);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	
	List<User> findAll();
	
	void removeOne(Long id);
	
	User findOne(Long id);
}
