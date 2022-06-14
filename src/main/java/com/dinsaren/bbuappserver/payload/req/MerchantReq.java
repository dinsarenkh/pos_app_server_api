package com.dinsaren.bbuappserver.payload.req;

import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import java.math.BigDecimal;
import javax.persistence.Column;
import lombok.Data;

@Data
public class MerchantReq {
    private int id;
    private String code;
    private Integer holderId;
    private String categoryKey;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private String address;
    private BigDecimal longAddress;
    private BigDecimal lateAddress;
    private String status;
    private String addressDes;

    public void setDataRes(MerchantReq data){
        this.holderId=data.getHolderId();
        this.categoryKey=data.getCategoryKey();
        this.nameEn=data.getNameEn();
        this.nameKh=data.getNameKh();
        this.imageUrl=data.getImageUrl();
        this.address=data.getAddress();
        this.status=data.getStatus();
        this.lateAddress=data.getLateAddress();
        this.longAddress=data.getLongAddress();
        this.addressDes=data.addressDes;
    }


}
