package com.norulesweb.springapp.core.services.user;

public interface UserService {
	AppUserDTO createAppUser(AppUserDTO userDTO);
	AppUserDTO findUserByUserId(String userId);
	AppUserDTO addAdminAuth(AppUserDTO userDTO);
	AppUserDTO addUserAuth(AppUserDTO userDTO);
	AppUserDTO saveUserChanges(AppUserDTO userDTO);
}
