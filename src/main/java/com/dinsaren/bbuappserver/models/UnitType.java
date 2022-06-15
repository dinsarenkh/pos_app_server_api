package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(	name = "pos_unit_types")
@Data
public class UnitType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_kh")
    private String nameKh;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "merchant_id")
    private Integer merchantId;
    private String status = Constants.ACTIVE_STATUS;
    private String type;
    public void setCreate(UnitTypeCreateReq data){
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.status = Constants.ACTIVE_STATUS;
        this.qty = data.getQty();
        this.merchantId=data.getMerchantId();
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
        this.type = data.getType();
    }

    public void setUpdate(UnitTypeCreateReq data){
        this.id = data.getId();
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.status = Constants.ACTIVE_STATUS;
        this.qty = data.getQty();
        this.merchantId=data.getMerchantId();
        this.setUpdateAt(new Date());
        this.setUpdateBy(Constants.APP);
    }

}
