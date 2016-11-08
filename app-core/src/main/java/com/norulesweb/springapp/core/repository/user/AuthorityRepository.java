package com.norulesweb.springapp.core.repository.user;

import com.norulesweb.springapp.core.common.AppRepository;
import com.norulesweb.springapp.core.model.user.Authority;
import com.norulesweb.springapp.core.model.user.AuthorityName;

import java.util.List;

public interface AuthorityRepository extends AppRepository<Authority, Long> {
	Authority findByAuthorityName(AuthorityName authorityName);
	List<Authority> findAll();
}
