package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.OutletReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pos_outlet")
@Data
public class Outlet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Column(name = "merchant_id")
    private Integer merchantId;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_kh")
    private String nameKh;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "address")
    private String address;
    @Column(name = "address_des")
    private String addressDes;
    @Column(name = "long_address")
    private BigDecimal longAddress;
    @Column(name = "late_address")
    private BigDecimal lateAddress;
    private String status = Constants.ACTIVE_STATUS;

    public void setCreate(OutletReq data){
        this.code=data.getCode();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.imageUrl=data.getImageUrl();
        this.address=data.getAddress();
        this.status=data.getStatus();
        this.lateAddress=data.getLateAddress();
        this.longAddress=data.getLongAddress();
        this.addressDes=data.getAddressDes();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());
    }
    
    public void setUpdate(OutletReq data){
        this.id=data.getId();
        this.code=data.getCode();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.imageUrl=data.getImageUrl();
        this.address=data.getAddress();
        this.status=data.getStatus();
        this.lateAddress=data.getLateAddress();
        this.longAddress=data.getLongAddress();
        this.addressDes=data.getAddressDes();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());
    }

}
