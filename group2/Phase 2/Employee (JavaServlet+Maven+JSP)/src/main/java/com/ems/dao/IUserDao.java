package com.ems.dao;

import com.ems.exceptions.UserNotFoundException;
import com.ems.model.User;

public interface IUserDao {
	
	public void add(User user);
	public User findUserById(String id) throws UserNotFoundException;


}
