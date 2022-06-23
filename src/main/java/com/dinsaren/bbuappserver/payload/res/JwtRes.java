package com.dinsaren.bbuappserver.payload.res;

import lombok.Data;

import java.util.List;

@Data
public class JwtRes {
	private Long id;
	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private String username;
	private String email;
	private String profile;
	private String nationalId;
	private String nationalImage;
	private String address;
	private List<String> roles;

}
