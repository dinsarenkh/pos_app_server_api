package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

@Data
public class ProductCreateRes extends BaseEntityRes {
    private int id;
    private String nameEn;
    private String nameKh;
    private String code;
    private String barcode;
    private String qrCode;
    private String image;
    private String type;
    private Double quantity;
    private Double 	qtyAlert;
    private String note;
    private CategoryRes categoryRes;
    private String status;

}
