package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Category;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

@Data
public class CategoryRes extends BaseEntityRes {
    private int id;
    private String code;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private Integer parentId = Constants.NUMBER_ZERO;
    private String status = Constants.ACTIVE_STATUS;
    private Integer merchantId;
    private String type;

    public void setDataRes(Category data) {
        this.id = data.getId();
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.parentId = data.getParentId();
        this.status = data.getStatus();
        this.merchantId=data.getMerchantId();
        this.type=data.getType();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());
    }


}
