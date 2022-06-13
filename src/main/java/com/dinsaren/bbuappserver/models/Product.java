package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.ProductCreateReq;
import com.dinsaren.bbuappserver.payload.req.ProductUpdateReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_products")
@Data
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_kh")
    private String nameKh;
    @Column(name = "code")
    private String code;
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "qr_code")
    private String qrCode;
    @Column(name = "image")
    private String image;
    @Column(name = "type")
    private String type;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "qty_alert")
    private Double qtyAlert;
    @Column(name = "note")
    private String note;
    @Column(name = "category_id")
    private int categoryId;
    private String status;

    public void setCreate(ProductCreateReq data) {
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
        this.status = Constants.ACTIVE_STATUS;
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

    public void setUpdate(ProductUpdateReq data) {
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
        this.status = Constants.ACTIVE_STATUS;
        this.setUpdateAt(new Date());
        this.setUpdateBy(Constants.APP);
    }


}
