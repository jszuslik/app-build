package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;
import com.norulesweb.springapp.core.model.user.AuthorityName;
import com.norulesweb.springapp.core.repository.user.AuthorityRepository;
import com.norulesweb.springapp.core.services.utilities.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	protected AuthorityRepository authorityRepository;

	@Override
	public AuthorityDTO findAuthorityByName(String name){
		Authority authority;
		switch (name){
			case AppConstants.USER_ROLE_ADMIN:
				authority = authorityRepository.findByAuthorityName(AuthorityName.ROLE_ADMIN);
				break;
			case AppConstants.USER_ROLE_USER:
				authority = authorityRepository.findByAuthorityName(AuthorityName.ROLE_USER);
				break;
			default:
				authority = null;
				break;
		}
		if(authority != null) {
			return new AuthorityDTO(authority);
		}
		return null;
	}

	@Override
	public List<AuthorityDTO> getAllAuthorities() {
		List<Authority> authorities = authorityRepository.findAll();
		List<AuthorityDTO> authorityDTOs = new ArrayList<>();
		for(Authority authority : authorities){
			AuthorityDTO authorityDTO = new AuthorityDTO(authority);
			authorityDTOs.add(authorityDTO);
		}
		return authorityDTOs;
	}

	@Override
	public AuthorityDTO saveAuthority(AuthorityDTO authorityDTO){
		Authority savedAuthority = authorityRepository.save(authorityDTO.buildModel());
		authorityRepository.flushAndRefresh(savedAuthority);
		return new AuthorityDTO(savedAuthority);
	}

	@Override
	public List<Authority> findByAppUser(AppUser appUser) {
		List<Authority> authorities = appUser.getAuthorities();
		List<Authority> userAuths = new ArrayList<>();
		for(Authority authority : authorities){
			for(AppUser user : authority.getAppUsers()){
				if(user.getId() == user.getId()){
					userAuths.add(authority);
				}
			}
		}
		return userAuths;
	}

}
