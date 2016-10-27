package com.norulesweb.springapp.core.model.user;

import com.norulesweb.springapp.core.model.common.ModelBase;
import com.norulesweb.springapp.core.model.common.ModelConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

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

	public AppUser() { }

	@Column(name = "USER_ID", length = ModelConstants.LEN_MEDIUM)
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

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				       .append("id", id)
				       .append("userId", userId)
				       .toString();
	}
}
