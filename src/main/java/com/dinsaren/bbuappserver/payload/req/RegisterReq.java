package com.dinsaren.bbuappserver.payload.req;

import lombok.Data;

@Data
public class RegisterReq {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String profile;
    private String nationalId;
    private String nationalImage;
    private String address;

}
