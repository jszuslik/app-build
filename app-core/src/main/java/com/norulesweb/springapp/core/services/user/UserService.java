package com.norulesweb.springapp.core.services.user;

public interface UserService {
	AppUserDTO createAppUser(AppUserDTO userDTO);
	AppUserDTO findUserByUserId(String userId);
}
