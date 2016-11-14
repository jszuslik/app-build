package com.norulesweb.springapp.core.security;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;
import com.norulesweb.springapp.core.repository.user.AppUserRepository;
import com.norulesweb.springapp.core.repository.user.AuthorityRepository;
import com.norulesweb.springapp.core.services.user.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	protected AppUserRepository appUserRepository;

	@Autowired
	protected AuthorityRepository authorityRepository;

	@Autowired
	protected AuthorityService authorityService;

	@Autowired
	public AppUserDetailsService(AppUserRepository appUserRepository, AuthorityRepository authorityRepository) {
		this.appUserRepository = appUserRepository;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByUserId(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			List<Authority> authorities = authorityService.findByAppUser(user);
			return AppUserFactory.create(user, authorities);
		}

	}
}
