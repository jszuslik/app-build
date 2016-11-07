package com.norulesweb.springapp.core.services.user;

public interface UserService {
	AppUserDTO createAppUser(String userId, String plainTextPassword, String roles);
	AppUserDTO findUserByUserId(String userId);
}
