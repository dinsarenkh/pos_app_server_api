package com.dinsaren.bbuappserver.payload.req;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
public class CategoryCreateReq {
    private int id;
    private String code;
    private String nameEn;
    private String nameKh;
    private String imageUrl;
    private Integer parentId = Constants.NUMBER_ZERO;

}
