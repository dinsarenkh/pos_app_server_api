package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.models.Product;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

@Data
public class ProductRes extends BaseEntityRes {
    private int id;
    private String nameEn;
    private String nameKh;
    private String code;
    private String barcode;
    private String qrCode;
    private String image;
    private String type;
    private Double quantity;
    private Double qtyAlert;
    private String note;
    private CategoryRes categoryRes;
    private String status;
    private int categoryId;

    public void setDataRes(Product data, CategoryRes categoryRes) {
        this.id = data.getId();
        this.code = data.getCode();
        this.barcode = data.getBarcode();
        this.qrCode = data.getQrCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.image = data.getImage();
        this.type = data.getType();
        this.quantity = data.getQuantity();
        this.qtyAlert = data.getQtyAlert();
        this.note = data.getNote();
        this.categoryId = data.getCategoryId();
        this.categoryRes = categoryRes;
        this.status = data.getStatus();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());
    }

}
