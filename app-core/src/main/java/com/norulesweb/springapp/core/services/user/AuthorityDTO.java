package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;
import com.norulesweb.springapp.core.model.user.AuthorityName;

import java.util.LinkedList;
import java.util.List;

public class AuthorityDTO {

	protected Long id;

	protected String authorityName;

	protected List<AppUserDTO> appUsers;

	public AuthorityDTO() { }

	public AuthorityDTO(Authority authority) {

		if(authority.getId() != null) {
			setId(authority.getId());
		}

		if(authority.getAuthorityName() != null) {
			setAuthorityName(authority.getAuthorityName().name());
		}

		if(authority.getAppUsers() != null) {
			for(AppUser appUser : authority.getAppUsers()){
				addAppUser(new AppUserDTO(appUser));
			}
		}
	}

	public Authority buildModel() {
		Authority authority = new Authority();

		if(getId() != null) {
			authority.setId(getId());
		}

		if(getAuthorityName() != null){
			switch (getAuthorityName()){
				case "ROLE_ADMIN":
					authority.setAuthorityName(AuthorityName.ROLE_ADMIN);
					break;
				case "ROLE_USER":
					authority.setAuthorityName(AuthorityName.ROLE_USER);
					break;
			}

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

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public List<AppUserDTO> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(List<AppUserDTO> appUsers) {
		this.appUsers= appUsers;
	}

	public void addAppUser(AppUserDTO appUserDTO){
		if(this.appUsers == null){
			appUsers = new LinkedList<>();
		}
		appUsers.add(appUserDTO);
	}
}
