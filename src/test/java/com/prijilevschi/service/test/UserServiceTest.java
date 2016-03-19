package com.prijilevschi.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.prijilevschi.config.TestConfig;
import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	private User user;
	
	@Before
	public void init(){
		System.out.println("before");
		user = new User();
		//user.setId(1L);
		user.setName("magister");
		user.setPassword("passw0rd");
		userService.save(user);
	}
	
	
	@Test
	public void findByUserNameTest(){
		User actualUser = userService.findByUserName(user.getName());
		Assert.assertEquals(user.getPassword(), actualUser.getPassword());
	}
}
