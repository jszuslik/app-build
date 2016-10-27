package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.repository.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	protected AppUserRepository appUserRepository;

	@Override
	public AppUserDTO createAppUser(String userId, String plaintextpassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		AppUser appUser = new AppUser();
		appUser.setUserId(userId);
		appUser.setPassword(passwordEncoder.encode(plaintextpassword));

		AppUser savedUser = appUserRepository.save(appUser);

		appUserRepository.flushAndRefresh(savedUser);

		return new AppUserDTO(savedUser);
	}

	@Override
	@Transactional(readOnly = true)
	public AppUserDTO findUserByUserId(String userId){
		List<AppUser> users = appUserRepository.findByUserId(userId);
		if (userId.isEmpty()) {
			return null;
		} else {
			return new AppUserDTO(users.get(0));
		}
	}

}