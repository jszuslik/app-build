package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;

import java.util.Date;
import java.util.List;

public class AppUserDTO {

	protected Long id;

	protected String userId;

	protected String password;

	protected String firstName;

	protected String lastName;

	protected String email;

	protected Boolean enabled;

	protected Date lastPasswordResetDate;

	protected List<Authority> authorities;

	public AppUserDTO() { }

	public AppUserDTO(AppUser appUser) {
		setId(appUser.getId());
		setUserId(appUser.getUserId());
		setPassword(appUser.getPassword());
		setFirstName(appUser.getFirstName());
		setLastName(appUser.getLastName());
		setEmail(appUser.getEmail());
		setEnabled(appUser.getEnabled());
		setLastPasswordResetDate(appUser.getLastPasswordResetDate());
		setAuthorities(appUser.getAuthorities());
	}

	public AppUser buildModel() {
		AppUser appUser = new AppUser();
		appUser.setId(getId());
		appUser.setUserId(getUserId());
		// Do no expose password here
		appUser.setFirstName(getFirstName());
		appUser.setLastName(getLastName());
		appUser.setEmail(getEmail());
		appUser.setEnabled(getEnabled());
		appUser.setLastPasswordResetDate(getLastPasswordResetDate());
		appUser.setAuthorities(getAuthorities());
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}
