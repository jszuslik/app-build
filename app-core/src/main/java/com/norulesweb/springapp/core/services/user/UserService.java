package com.norulesweb.springapp.core.services.user;

public interface UserService {
	AppUserDTO createAppUser(AppUserDTO userDTO);
	AppUserDTO findUserByUserId(String userId);
	AppUserDTO saveUserChanges(AppUserDTO userDTO);
}
