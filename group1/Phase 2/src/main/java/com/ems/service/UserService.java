package com.ems.service;

import com.ems.model.User;

public interface UserService {
	public void add(User user);
	public User find(String email_id);

}
