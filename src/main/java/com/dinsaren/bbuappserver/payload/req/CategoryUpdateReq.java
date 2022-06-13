package com.dinsaren.bbuappserver.payload.req;

import com.dinsaren.bbuappserver.constants.Constants;
import lombok.Data;

@Data
public class CategoryUpdateReq {
    private int id;
    private String code;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private Integer parentId = Constants.NUMBER_ZERO;

}
