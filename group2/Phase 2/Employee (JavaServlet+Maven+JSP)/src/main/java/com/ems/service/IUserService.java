package com.ems.service;

import com.ems.exceptions.UserNotFoundException;
import com.ems.model.User;

public interface IUserService {
	
	public void add(User user);
	public User findUserById(String id) throws UserNotFoundException;
	


}
