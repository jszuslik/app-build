package com.norulesweb.springapp.core.security;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.repository.user.AppUserRepository;
import com.norulesweb.springapp.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	protected UserService userService;

	@Autowired
	protected AppUserRepository appUserRepository;

	@Override
	public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<AppUser> users = appUserRepository.findByUserId(username);
		AppUser user = users.get(0);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			return AppUserFactory.create(user);
		}

	}
}
