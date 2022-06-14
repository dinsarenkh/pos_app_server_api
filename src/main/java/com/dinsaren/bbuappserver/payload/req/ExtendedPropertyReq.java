package com.dinsaren.bbuappserver.payload.req;

import lombok.Data;

@Data
public class ExtendedPropertyReq {
    private int id;
    private String code;
    private String nameEn;
    private String nameKh;
    private String key;
    private String value;
    private String status;

}
