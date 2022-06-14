package com.dinsaren.bbuappserver.payload.req;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Outlet;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OutletReq extends BaseEntity {
    private int id;
    private String code;
    private Integer merchantId;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private String address;
    private String addressDes;
    private BigDecimal longAddress;
    private BigDecimal lateAddress;
    private String status = Constants.ACTIVE_STATUS;

    public void setDataRes(Outlet data){
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
