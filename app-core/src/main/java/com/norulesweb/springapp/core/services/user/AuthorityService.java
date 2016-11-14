package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;

import java.util.List;

public interface AuthorityService {
	AuthorityDTO findAuthorityByName(String name);
	List<AuthorityDTO> getAllAuthorities();
	AuthorityDTO saveAuthority(AuthorityDTO authorityDTO);
	List<Authority> findByAppUser(AppUser appUser);
}
