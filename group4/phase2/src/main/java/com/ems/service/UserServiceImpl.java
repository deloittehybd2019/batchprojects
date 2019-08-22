package com.ems.service;

import com.ems.dao.DAO;
import com.ems.dao.UserJdbcImpl;
import com.ems.model.User;

public class UserServiceImpl implements UserService{

	
	private DAO dao;
	
	public UserServiceImpl(UserJdbcImpl userJdbcImpl) {
		this.dao=userJdbcImpl;
	}

	@Override
	public void add(User user)
	{
		dao.add(user);
	}
	
	@Override
	public User find(String email_id)
	{
		return dao.find(email_id);
		
	}
	

}
