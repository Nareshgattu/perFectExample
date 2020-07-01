package com.perFectExample.demo.security.model;

public class AuthenticationResponse {

	private String jwtToken;
	private String username;

	public AuthenticationResponse(String jwt, String username) {
		this.jwtToken=jwt;
		this.username=username;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
