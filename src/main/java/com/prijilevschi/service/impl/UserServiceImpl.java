package com.prijilevschi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
	@Autowired
	private UserDAO userDao;

	@Override	
	public User findByUserName(String name) {
		return userDao.findByUserName(name);
	}
	
	
}
