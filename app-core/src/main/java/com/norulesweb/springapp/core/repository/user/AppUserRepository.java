package com.norulesweb.springapp.core.repository.user;

import com.norulesweb.springapp.core.common.AppRepository;
import com.norulesweb.springapp.core.model.user.AppUser;

import java.util.List;

public interface AppUserRepository extends AppRepository<AppUser, Long> {
	List<AppUser> findByUserId(String userId);
}
