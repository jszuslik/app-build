package com.norulesweb.springapp.core.model.user;

import com.norulesweb.springapp.core.model.common.ModelBase;
import com.norulesweb.springapp.core.model.common.ModelConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(
		name="USER",
		indexes = {
				@Index(columnList = "USER_ID")
		}
)
public class AppUser extends ModelBase {

	private String userId;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private Boolean enabled;

	private Date lastPasswordResetDate;

	private List<Authority> authorities;

	public AppUser() { }

	@Column(name = "USER_ID", length = ModelConstants.LEN_MEDIUM, unique = true)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PASSWORD", length = ModelConstants.LEN_NORMAL)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "FIRSTNAME", length = ModelConstants.LEN_NORMAL)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LASTNAME", length = ModelConstants.LEN_NORMAL)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL", length = ModelConstants.LEN_NORMAL)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ENABLED")
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "LASTPASSWORDRESETDATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USER_AUTHORITY",
			joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public void addAuthority(Authority authority){
		if(this.authorities == null){
			this.authorities = new ArrayList<>();
		}
		this.authorities.add(authority);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				       .append("id", id)
				       .append("userId", userId)
				       .toString();
	}
}
