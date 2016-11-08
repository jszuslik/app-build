package com.norulesweb.springapp.core.model.user;

import com.norulesweb.springapp.core.model.common.ModelBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
		name = "AUTHORITIES"
)
public class Authority extends ModelBase {

	private AuthorityName authorityName;

	private List<AppUser> appUsers;

	public Authority() { }

	@Column(name = "NAME", length = 50)
	@Enumerated(EnumType.STRING)
	public AuthorityName getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(AuthorityName authorityName) {
		this.authorityName = authorityName;
	}

	@ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
	public List<AppUser> getAppUsers() {
		return appUsers;
	}
	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}
	public void addAppUser(AppUser appUser) {
		if (this.appUsers == null) {
			this.appUsers = new ArrayList<>();
		}
		this.appUsers.add(appUser);
	}
}
