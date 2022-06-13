package com.dinsaren.bbuappserver.payload.req;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UnitTypeUpdateReq {
    private Integer id;
    private String code;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private Integer qty;
    
}
