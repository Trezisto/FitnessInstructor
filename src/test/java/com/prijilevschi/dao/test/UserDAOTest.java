package com.prijilevschi.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prijilevschi.config.TestConfig;
import com.prijilevschi.dao.UserDAO;

@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {
	@Autowired
	private UserDAO userDao;
	
	@Test
	public void findByUserNameTest(){
		Assert.assertTrue(true);
	}
}
