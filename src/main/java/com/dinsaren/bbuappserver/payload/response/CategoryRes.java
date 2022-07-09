package com.dinsaren.bbuappserver.payload.response;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Category;
import lombok.Data;

@Data
public class CategoryRes {
    private Long id;
    private String name;
    private String imageUrl;
    private String status = Constants.ACTIVE_STATUS;
    private Integer parentId = 0;

    public void setData(Category data){
        this.id =data.getId();
        this.name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.parentId = data.getParentId();
        this.status = data.getStatus();
    }
}
