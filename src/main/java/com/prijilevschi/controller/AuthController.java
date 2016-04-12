package com.prijilevschi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Authentification Controller
 * @author Evgheni Prijilevschi
 *
 */
@Controller
@RequestMapping(method = RequestMethod.POST)
public class AuthController {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping("login")
	public String login(@RequestParam final String username, @RequestParam final String password) {
		userDetailsService.loadUserByUsername(username);
		return "index";
	}
	
	@RequestMapping("logout")
	public String logout() {
		return null;
		
	}
}
