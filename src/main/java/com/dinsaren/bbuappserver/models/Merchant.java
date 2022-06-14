package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.MerchantReq;
import com.dinsaren.bbuappserver.payload.res.MerchantRes;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pos_merchants")
@Data
public class Merchant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Column(name = "holder_id")
    private Integer holderId;
    @Column(name = "category_key")
    private String categoryKey;
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

    public void setCreate(MerchantReq data){
        this.holderId=data.getHolderId();
        this.categoryKey=data.getCategoryKey();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.imageUrl=data.getImageUrl();
        this.address=data.getAddress();
        this.status=data.getStatus();
        this.lateAddress=data.getLateAddress();
        this.longAddress=data.getLongAddress();
    }

    public void setUpdate(MerchantReq data){
        this.id=data.getId();
        this.holderId=data.getHolderId();
        this.categoryKey=data.getCategoryKey();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.imageUrl=data.getImageUrl();
        this.address=data.getAddress();
        this.status=data.getStatus();
        this.lateAddress=data.getLateAddress();
        this.longAddress=data.getLongAddress();
    }


}
