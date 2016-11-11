package com.norulesweb.springapp.core.security.service;

import java.io.Serializable;

public class AppAuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1250166508152483573L;

	private final String token;

	public AppAuthenticationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}
