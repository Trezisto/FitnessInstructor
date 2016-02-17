package com.prijilevschi.service;

import com.prijilevschi.model.User;

public interface UserService extends AbstractService<User>{
	User findByUserName(String name);
}
