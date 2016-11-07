package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;

public class AppUserDTO {

	protected Long id;

	protected String userId;

	protected String password;

	public AppUserDTO() { }

	public AppUserDTO(AppUser appUser) {
		setId(appUser.getId());
		setUserId(appUser.getUserId());
		setPassword(appUser.getPassword());
	}

	public AppUser buildModel() {
		AppUser appUser = new AppUser();
		appUser.setId(getId());
		appUser.setUserId(getUserId());
		// Do no expose password here
		return appUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
