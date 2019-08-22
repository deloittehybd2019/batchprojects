package com.ems.service;
import com.ems.dao.IUserDao;
import com.ems.exceptions.UserNotFoundException;
import com.ems.model.User;

public class UserImpl implements IUserService{

	private IUserDao dao;

    public IUserDao getDao() {
        return dao;
    }

    public UserImpl(IUserDao dao) {
        this.dao = dao;
    }
    
    @Override
    public void add(User user) {
        
        getDao().add(user);
    }
    
    @Override
    public User findUserById(String id) throws UserNotFoundException {
        User user = getDao().findUserById(id);
        return user;
    }


}
