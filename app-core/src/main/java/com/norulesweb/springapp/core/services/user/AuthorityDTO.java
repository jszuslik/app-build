package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;
import com.norulesweb.springapp.core.model.user.AuthorityName;

import java.util.LinkedList;
import java.util.List;

public class AuthorityDTO {

	protected Long id;

	protected AuthorityName authorityName;

	protected List<AppUserDTO> appUsers;

	public AuthorityDTO() { }

	public AuthorityDTO(Authority authority) {

		if(authority.getId() != null) {
			setId(authority.getId());
		}

		if(authority.getAuthName() != null) {
			setAuthorityName(authority.getAuthName());
		}

		if(authority.getAppUsers() != null) {
			appUsers = new LinkedList<>();
			for(AppUser appUser : authority.getAppUsers()) {
				appUsers.add(AppUserDTO.buildDTO(appUser));
			}
		}
	}

	public Authority buildModel() {
		Authority authority = new Authority();

		if(getId() != null) {
			authority.setId(getId());
		}

		if(getAuthorityName() != null){
			authority.setAuthName(getAuthorityName());
		}

		if(getAppUsers() != null) {
			List<AppUser> appUsers = new LinkedList<>();
			for (AppUserDTO appUserDTO : getAppUsers()){
				AppUser appUser = appUserDTO.buildModel();
				appUsers.add(appUser);
			}
			authority.setAppUsers(appUsers);
		}

		return authority;
	}

	public static AuthorityDTO buildDTO(Authority authority) {
		if(authority != null){
			return new AuthorityDTO(authority);
		} else {
			return null;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthorityName getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(AuthorityName authorityName) {
		this.authorityName = authorityName;
	}

	public List<AppUserDTO> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(List<AppUserDTO> appUsers) {
		this.appUsers= appUsers;
	}
}
