package com.prijilevschi.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prijilevschi.dao.UserDAO;
import com.prijilevschi.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add( new SimpleGrantedAuthority(user.getUserRole().toString()) );
		return buildUserForAuthentication(user, authorities);
	}
	
	/**
	 * Converting user for Spring Security
	 * 
	 * @param user com.prijilevschi.model.User
	 * @param authorities user privileges 
	 * @return org.springframework.security.core.userdetails.User
	 */
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(
				User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(
				user.getName(), user.getPassword(),	user.getIsEnabled(), true, true, true, authorities);
	}

}
