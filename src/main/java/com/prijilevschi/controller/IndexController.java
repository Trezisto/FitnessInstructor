package com.prijilevschi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prijilevschi.model.json.Credentials;

@Controller
public class IndexController {
	private Boolean signedIn = Boolean.FALSE;
	private UserDetails userDetails;
	
	private final String INDEX_NOT_SIGNED_IN = "indexNotSignedIn";
	private final String INDEX_SIGNED_IN = "indexSignedIn";
	
	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(value = "/index")
	public String getIndex() {
		return signedIn ? INDEX_SIGNED_IN : INDEX_NOT_SIGNED_IN;
	}
	
	/**
	 * Authentification sign in
	 * @param credentials username/password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody final Credentials credentials) {
		userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
		signedIn = Boolean.TRUE;
		return INDEX_SIGNED_IN;
	}
	
	/**
	 * Redirect to main page
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(){
		return INDEX_NOT_SIGNED_IN;
	}
	
	/**
	 * Authentification sign out
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		signedIn = Boolean.FALSE;
		return INDEX_NOT_SIGNED_IN;
	}
}
