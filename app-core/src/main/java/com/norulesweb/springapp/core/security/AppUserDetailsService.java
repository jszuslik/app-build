package com.norulesweb.springapp.core.security;

import com.norulesweb.springapp.core.services.user.AppUserDTO;
import com.norulesweb.springapp.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	protected UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUserDTO userDTO = userService.findUserByUserId(username);

		if (userDTO == null)
			throw new UsernameNotFoundException(username + " not found");

		AppUserDetails userDetails = new AppUserDetails(userDTO);

		return userDetails;
	}
}
