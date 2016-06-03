package com.prijilevschi.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;
import com.prijilevschi.service.test.UserServiceTest;
import com.prijilevschi.utils.HashPBKDF2Util;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
	@Autowired
	private UserDAO userDao;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	@Transactional(readOnly = true)
	public User findByUserName(String name) {
		return userDao.findByUserName(name);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		User user = userDao.findByUserName(username);
		if (user != null) {
			return HashPBKDF2Util.validatePassword(password, user.getPassword());
		} else {
			return false;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean checkUserExists(String username){
		User user = userDao.findByUserName(username);
		return user != null;
	}

	@Override
	@Transactional
	public void register(String name, String password) {
		boolean usernameNotUsed = !checkUserExists(name);
		if(usernameNotUsed) {
			User user = new User();
			findByUserName(name);
			user.setName(name);
			if (password != null) {
				try {
					user.setPassword(HashPBKDF2Util.generateStorngPasswordHash(password));
				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
					logger.error("Hashing password was unsuccessful for user: [" + user.getName() + "]", e);
				}
			} else {
				logger.warn("Password was not found for user: [{}]", user.getName());
			}
			save(user);
		}
	}
	
	
}
