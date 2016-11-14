package com.norulesweb.springapp.core.repository.user;

import com.norulesweb.springapp.core.common.AppRepository;
import com.norulesweb.springapp.core.model.user.AppUser;

public interface AppUserRepository extends AppRepository<AppUser, Long> {
	AppUser findByUserId(String userId);
}
