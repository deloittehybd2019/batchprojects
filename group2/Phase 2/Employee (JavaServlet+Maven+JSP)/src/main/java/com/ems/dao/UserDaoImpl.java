package com.ems.dao;

import java.util.HashMap;
import java.util.Map;



import com.ems.exceptions.UserNotFoundException;
import com.ems.model.User;


public class UserDaoImpl implements IUserDao{

	 private Map<String,User> store = new HashMap<>();
	 
	 public Map<String,User> getStore() {
	        return store;
	    }

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		getStore().put(user.getEmailid(),user);
		
	}

	@Override
	public User findUserById(String id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		 User user = getStore().get(id);
	        if (user == null) {
	            throw new UserNotFoundException("User not found for emailid=" + id);
	        }
	        return user;
		
	}

	

}
