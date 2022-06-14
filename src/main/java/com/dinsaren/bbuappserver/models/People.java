package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.PeopleReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pos_people")
@Data
public class People extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "type")
	private String type;
	@Column(name = "merchant_id")
	private Integer merchantId;
	private String status = Constants.ACTIVE_STATUS;

	public void setDataCreate(PeopleReq data){
		this.code=data.getCode();
		this.name=data.getName();
		this.phone=data.getPhone();
		this.email=data.getEmail();
		this.address=data.getAddress();
		this.type=data.getType();
		this.merchantId=data.getMerchantId();
		this.status=Constants.ACTIVE_STATUS;
		this.setCreateAt(new Date());
		this.setCreateBy(Constants.APP);
	}

	public void setDataUpdate(PeopleReq data){
		this.id=data.getId();
		this.code=data.getCode();
		this.name=data.getName();
		this.phone=data.getPhone();
		this.email=data.getEmail();
		this.address=data.getAddress();
		this.type=data.getType();
		this.status=Constants.ACTIVE_STATUS;
		this.setUpdateAt(new Date());
		this.setUpdateBy(Constants.APP);
		this.merchantId=data.getMerchantId();
	}


}
