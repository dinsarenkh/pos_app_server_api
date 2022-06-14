package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.models.ExtendedProperty;
import com.dinsaren.bbuappserver.models.People;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

@Data
public class ExtendedPropertyRes extends BaseEntityRes {
    private int id;
    private String code;
    private String nameEn;
    private String nameKh;
    private String key;
    private String value;
    private String status;

    public void setData(ExtendedProperty data){
        this.id=data.getId();
        this.code=data.getCode();
        this.value=data.getValue();
        this.key=data.getKey();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.status=data.getStatus();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());
    }

}
