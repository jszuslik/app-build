package com.norulesweb.springapp.core.model.user;

import com.norulesweb.springapp.core.model.common.ModelBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Authority extends ModelBase {

	private AuthorityName name;

	private List<AppUser> users;

	public Authority() { }

	@Column(name = "NAME", length = 50)
	@Enumerated(EnumType.STRING)
	public AuthorityName getName() {
		return name;
	}
	public void setName(AuthorityName name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
	public List<AppUser> getUsers() {
		return users;
	}
	public void setUsers(List<AppUser> users) {
		this.users = users;
	}
	public void addUser(AppUser user) {
		if (this.users == null) {
			this.users = new ArrayList<>();
		}
		this.users.add(user);
	}
}
