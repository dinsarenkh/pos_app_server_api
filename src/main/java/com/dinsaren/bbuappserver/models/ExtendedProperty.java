package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.ExtendedPropertyReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pos_extended_properties")
@Data
public class ExtendedProperty extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_kh")
    private String nameKh;
    @Column(name = "data_key")
    private String key;
    @Column(name = "data_value")
    private String value;
    private String status = Constants.ACTIVE_STATUS;

    public void setCreate(ExtendedPropertyReq data){
        this.code=data.getCode();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.key=data.getKey();
        this.value=data.getValue();
        this.status=Constants.ACTIVE_STATUS;
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

    public void setUpdate(ExtendedPropertyReq data){
        this.id=data.getId();
        this.code=data.getCode();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.key=data.getKey();
        this.value=data.getValue();
        this.setUpdateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

}
