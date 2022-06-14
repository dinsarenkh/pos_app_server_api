package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.models.Role;
import com.dinsaren.bbuappserver.models.User;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class UserRes {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String status;
    private Set<Role> roles = new HashSet<>();
    private String nationalId;
    private String nationalImage;
    private String address;
    private String profile;

    public void setDataRes(User data){
        this.id=data.getId();
        this.username=data.getUsername();
        this.email=data.getEmail();
        this.password = data.getPassword();
        this.phone=data.getPhone();
        this.status=data.getStatus();
        this.roles=data.getRoles();
        this.profile=data.getProfile();
        this.nationalId=data.getNationalId();
        this.nationalImage=data.getNationalImage();
        this.address=data.getAddress();
    }

}
