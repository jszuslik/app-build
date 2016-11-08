package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.repository.user.AppUserRepository;
import com.norulesweb.springapp.core.repository.user.AuthorityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	protected AppUserRepository appUserRepository;

	@Autowired
	protected AuthorityRepository authorityRepository;

	@Autowired
	protected AuthorityService authorityService;

	@Override
	public AppUserDTO createAppUser(AppUserDTO newUserDTO) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String encodedPassword = passwordEncoder.encode(newUserDTO.getPassword());
		newUserDTO.setPassword(encodedPassword);

		AppUser savedUser = appUserRepository.save(newUserDTO.buildModel());

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

	@Override
	public AppUserDTO saveUserChanges(AppUserDTO appUserDTO) {
		AppUser savedUser = appUserRepository.save(appUserDTO.buildModel());

		appUserRepository.flushAndRefresh(savedUser);

		return new AppUserDTO(savedUser);
	}

}
