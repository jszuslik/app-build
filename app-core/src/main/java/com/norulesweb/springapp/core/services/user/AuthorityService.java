package com.norulesweb.springapp.core.services.user;

import java.util.List;

public interface AuthorityService {
	AuthorityDTO findAuthorityByName(String name);
	List<AuthorityDTO> getAllAuthorities();
	AuthorityDTO saveAuthority(AuthorityDTO authorityDTO);
}
