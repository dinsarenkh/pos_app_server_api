package com.dinsaren.bbuappserver.payload.response;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Category;
import com.dinsaren.bbuappserver.models.Product;
import lombok.Data;


@Data
public class ProductRes {
    private Long id;
    private String name;
    private String imageUrl;
    private String categoryId;
    private Category category;
    private String status = Constants.ACTIVE_STATUS;
    private double price;
    private double qty;
    private double discount;

    public void setData(Product data, Category category){
        this.id=data.getId();
        this.name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.categoryId = data.getCategoryId();
        this.status = data.getStatus();
        this.category = category;
        this.price = data.getPrice();
        this.qty = data.getQty();
        this.discount = data.getDiscount();
    }

}
