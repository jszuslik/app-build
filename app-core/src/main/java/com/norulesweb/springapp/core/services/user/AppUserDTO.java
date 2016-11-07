package com.norulesweb.springapp.core.services.user;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.model.user.Authority;

import java.util.Date;
import java.util.LinkedList;
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

	protected List<AuthorityDTO> authorities;

	public AppUserDTO() { }

	public AppUserDTO(AppUser appUser) {

		if(appUser.getId() != null){
			setId(appUser.getId());
		}

		if(appUser.getUserId() != null) {
			setUserId(appUser.getUserId());
		}

		if(appUser.getPassword() != null){
			setPassword(appUser.getPassword());
		}

		if(appUser.getFirstName() != null){
			setFirstName(appUser.getFirstName());
		}

		if(appUser.getLastName() != null){
			setLastName(appUser.getLastName());
		}

		if(appUser.getEmail() != null){
			setEmail(appUser.getEmail());
		}

		if(appUser.getEnabled() != null){
			setEnabled(appUser.getEnabled());
		}

		if(appUser.getLastPasswordResetDate() != null){
			setLastPasswordResetDate(appUser.getLastPasswordResetDate());
		}

		if(appUser.getAuthorities() != null){
			authorities = new LinkedList<>();
			for(Authority authority : appUser.getAuthorities()){
				authorities.add(AuthorityDTO.buildDTO(authority));
			}
		}
	}

	public AppUser buildModel() {
		AppUser appUser = new AppUser();

		if(getId() != null){
			appUser.setId(getId());
		}

		if(getUserId() != null){
			appUser.setUserId(getUserId());
		}

		if(getPassword() != null){
			appUser.setPassword(getPassword());
		}

		if(getFirstName() != null){
			appUser.setFirstName(getFirstName());
		}

		if(getLastName() != null){
			appUser.setLastName(getLastName());
		}

		if(getEmail() != null){
			appUser.setEmail(getEmail());
		}

		if(getEnabled() != null){
			appUser.setEnabled(getEnabled());
		}

		if(getLastPasswordResetDate() != null){
			appUser.setLastPasswordResetDate(getLastPasswordResetDate());
		}

		if(getAuthorities() != null){
			List<Authority> authorities = new LinkedList<>();
			for(AuthorityDTO authorityDTO : getAuthorities()){
				Authority authority = authorityDTO.buildModel();
				authorities.add(authority);
			}
			appUser.setAuthorities(authorities);
		}

		return appUser;
	}

	public static AppUserDTO buildDTO(AppUser appUser){
		if(appUser != null){
			return new AppUserDTO(appUser);
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

	public List<AuthorityDTO> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityDTO> authorities) {
		this.authorities = authorities;
	}
}
