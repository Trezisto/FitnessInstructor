package com.prijilevschi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prijilevschi.model.json.Credentials;

/**
 * Authentification Controller
 * @author Evgheni Prijilevschi
 *
 */
@Controller
public class AuthController {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody final Credentials credentials) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login(){
		return "index";
	}
	
	@RequestMapping("logout")
	public String logout() {
		return null;
		
	}
}
