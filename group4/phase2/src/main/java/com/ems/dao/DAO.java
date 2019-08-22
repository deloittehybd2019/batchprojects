package com.ems.dao;

import com.ems.model.User;

public interface DAO {
	public void add(User user);
	public int generateId();
	public User find(String email_id);
}