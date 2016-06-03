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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prijilevschi.config.TestConfig;
import com.prijilevschi.model.User;
import com.prijilevschi.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	private User user;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
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
		logger.debug("User found with id: [{}], name: [{}])", actualUser.getId(), actualUser.getName());
		Assert.assertEquals(user.getPassword(), actualUser.getPassword());
	}
}
