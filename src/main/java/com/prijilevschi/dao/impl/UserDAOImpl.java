package com.prijilevschi.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.prijilevschi.dao.AbstractDAO;
import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;
import com.prijilevschi.utils.Utils;

@Repository("userDao")
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {
	private final String USERNAME = "username";
	
	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User findByUserName(String username) {
		User user = null;
		TypedQuery<User> query = entityManager.createQuery("from " + 
				typeClass.getName() + " where username = :" + USERNAME, typeClass);
		query.setParameter(USERNAME, username);
		List<User> singleUserList = query.getResultList();
		if(!Utils.isEmpty(singleUserList)){
			user = singleUserList.get(0);
		}
		return user;
	}
	
}
