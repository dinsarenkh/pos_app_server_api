package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.models.Merchant;
import com.dinsaren.bbuappserver.models.UnitType;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class MerchantRes extends BaseEntityRes {
    private int id;
    private String code;
    private Integer holderId;
    private UserRes userRes;
    private String categoryKey;
    private ExtendedPropertyRes extendedPropertyRes;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private String address;
    private BigDecimal longAddress;
    private BigDecimal lateAddress;
    private String addressDes;
    private String status;
    private Integer cashiers;
    private Integer outlets;
    private Integer products;
    private Integer categories;
    private Integer unitTypes;

    public void setDataRes(
            Merchant data, UserRes userRes, ExtendedPropertyRes extendedPropertyRes,
            Integer cashiers, Integer outlets, Integer products, Integer categories, Integer unitTypes){
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
        this.userRes=userRes;
        this.extendedPropertyRes=extendedPropertyRes;
        this.outlets=outlets;
        this.cashiers=cashiers;
        this.categories=categories;
        this.unitTypes=unitTypes;
        this.addressDes=data.getAddressDes();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());
    }


}
