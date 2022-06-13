package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeUpdateReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
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
    private String status = Constants.ACTIVE_STATUS;

    public void setCreate(UnitTypeCreateReq data){
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.status = Constants.ACTIVE_STATUS;
        this.qty = data.getQty();
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

    public void setUpdate(UnitTypeUpdateReq data){
        this.id = data.getId();
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.status = Constants.ACTIVE_STATUS;
        this.qty = data.getQty();
        this.setUpdateAt(new Date());
        this.setUpdateBy(Constants.APP);
    }

}
