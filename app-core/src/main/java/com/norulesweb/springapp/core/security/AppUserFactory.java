package com.norulesweb.springapp.core.security;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class AppUserFactory {

	private AppUserFactory() { }

	public static AppUserDetails create(AppUser user, List<Authority> authorities) {
		return new AppUserDetails(
             user.getId(),
             user.getUserId(),
             user.getFirstName(),
             user.getLastName(),
             user.getEmail(),
             user.getPassword(),
             mapToGrantedAuthorities(authorities),
             user.getEnabled(),
             user.getLastPasswordResetDate()
		);
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		return authorities.stream()
				       .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName().name()))
				       .collect(Collectors.toList());
	}

}
