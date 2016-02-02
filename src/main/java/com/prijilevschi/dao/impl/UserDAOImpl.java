package com.prijilevschi.dao.impl;

import org.springframework.stereotype.Repository;

import com.prijilevschi.dao.AbstractDAO;
import com.prijilevschi.model.User;

@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements AbstractDAO<User> {

	public UserDAOImpl() {
		super(User.class);
	}
	
}
