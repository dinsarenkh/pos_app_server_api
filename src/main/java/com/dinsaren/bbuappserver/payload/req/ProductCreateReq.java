package com.dinsaren.bbuappserver.payload.req;

import lombok.Data;

@Data
public class ProductCreateReq {
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
    private int categoryId;
}
