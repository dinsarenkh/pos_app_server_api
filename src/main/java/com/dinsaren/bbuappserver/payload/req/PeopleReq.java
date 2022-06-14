package com.dinsaren.bbuappserver.payload.req;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.People;
import lombok.Data;

@Data
public class PeopleReq {
	private int id;
	private String code;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String type;
	private String status = Constants.ACTIVE_STATUS;

}
