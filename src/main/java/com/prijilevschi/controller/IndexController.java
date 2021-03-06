package com.prijilevschi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prijilevschi.model.User;
import com.prijilevschi.model.json.Credentials;
import com.prijilevschi.service.UserService;
import com.prijilevschi.service.impl.UserServiceImpl;

@Controller
public class IndexController {
	private Boolean signedIn = Boolean.FALSE;
	private UserDetails userDetails;
	
	private final String INDEX_NOT_SIGNED_IN = "indexNotSignedIn";
	private final String INDEX_SIGNED_IN = "indexSignedIn";
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index")
	public String getIndex() {
		return signedIn ? INDEX_SIGNED_IN : INDEX_NOT_SIGNED_IN;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestBody final Credentials credentials) {
		userService.register(credentials.getUsername(), credentials.getPassword());
		return INDEX_NOT_SIGNED_IN;
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
	
	// for 403 access denied page
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			logger.debug("Authentificated: Username [{}]" + userDetail.getUsername());

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
}
