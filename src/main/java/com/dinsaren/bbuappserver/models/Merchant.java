package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.CategoryCreateReq;
import com.dinsaren.bbuappserver.payload.req.CategoryUpdateReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pos_merchants")
@Data
public class Merchant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Column(name = "holder_id")
    private Integer holderId;
    @Column(name = "category_id")
    private String categoryId;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_kh")
    private String nameKh;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "address")
    private String address;
    private String status = Constants.ACTIVE_STATUS;

}
