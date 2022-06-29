package com.dinsaren.bbuappserver.payload.response;

import java.util.List;

public class JwtRes {
	private String accessToken;
	private String type = "Bearer";
	private String refreshToken;
	private Long id;
	private String username;
	private String email;
	private String phone;
	private List<String> roles;

	public JwtRes(String accessToken, String refreshToken, Long id, String username, String email, List<String> roles,String phone) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.phone =phone;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "JwtRes{" +
				"accessToken='" + accessToken + '\'' +
				", type='" + type + '\'' +
				", refreshToken='" + refreshToken + '\'' +
				", id=" + id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", roles=" + roles +
				'}';
	}
}
