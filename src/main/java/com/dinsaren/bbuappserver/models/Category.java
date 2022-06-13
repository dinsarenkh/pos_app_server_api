package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.CategoryCreateReq;
import com.dinsaren.bbuappserver.payload.req.CategoryUpdateReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pos_categories")
@Data
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "name_kh")
    private String nameKh;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "parent_id")
    private Integer parentId = Constants.NUMBER_ZERO;
    private String status = Constants.ACTIVE_STATUS;

    public void setCreate(CategoryCreateReq data) {
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.parentId = data.getParentId();
        this.status = Constants.ACTIVE_STATUS;
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

    public void setUpdate(CategoryUpdateReq data) {
        this.id = data.getId();
        this.code = data.getCode();
        this.nameEn = data.getNameEn();
        this.nameKh = data.getNameKh();
        this.imageUrl = data.getImageUrl();
        this.parentId = data.getParentId();
        this.status = Constants.ACTIVE_STATUS;
        this.setUpdateAt(new Date());
        this.setUpdateBy(Constants.APP);
    }


}
