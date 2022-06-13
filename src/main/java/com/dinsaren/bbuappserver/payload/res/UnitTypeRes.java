package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.models.UnitType;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

import java.math.BigInteger;

@Data
public class UnitTypeRes extends BaseEntityRes {
    private Integer id;
    private String code;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private Integer qty;
    private String status;

    public void setDateRes(UnitType data){
        this.id =data.getId();
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.status = data.getStatus();
        this.qty = data.getQty();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());
    }

}
