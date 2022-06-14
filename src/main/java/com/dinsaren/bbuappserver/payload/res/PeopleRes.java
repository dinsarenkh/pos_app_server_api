package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.People;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

@Data
public class PeopleRes extends BaseEntityRes {
	private int id;
	private String code;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String type;
	private String status = Constants.ACTIVE_STATUS;

	public void setData(People data){
		this.id=data.getId();
		this.code=data.getCode();
		this.name=data.getName();
		this.phone=data.getPhone();
		this.email=data.getEmail();
		this.address=data.getAddress();
		this.type=data.getType();
		this.status=data.getStatus();
		this.setCreateAt(data.getCreateAt());
		this.setCreateBy(data.getCreateBy());
		this.setUpdateAt(data.getUpdateAt());
		this.setUpdateBy(data.getUpdateBy());
	}

}
