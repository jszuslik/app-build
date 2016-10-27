package com.norulesweb.springapp.core.security;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.services.user.AppUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AppUserDetails implements UserDetails {

	private static final long serialVersionUID = -4958723639132118472L;

	protected String password;

	protected String username;

	protected boolean enabled;

	protected AppUser appUser;

	public AppUserDetails(AppUserDTO userDTO) {
		username = userDTO.getUserId();
		password = userDTO.getPassword();
		enabled = true;
		appUser = userDTO.buildModel();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	@Override
	public String toString() {
		return username + " - " + appUser.toString();
	}

}
