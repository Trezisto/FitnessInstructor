package com.prijilevschi.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.prijilevschi.model.User;

public interface UserService extends AbstractService<User>{
	User findByUserName(String name);
	void register(String name, String password);
	boolean login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
	boolean checkUserExists(String username);
}
