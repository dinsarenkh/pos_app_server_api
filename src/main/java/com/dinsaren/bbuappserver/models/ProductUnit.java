package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.ProductUnitReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pos_product_units")
@Entity
@Data
public class ProductUnit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "unit_type_id")
    private Integer unitTypeId;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "price")
    private BigDecimal price;
    private String status;

    public void setCreate(ProductUnitReq data){
        this.productId = data.getProductId();
        this.unitTypeId = data.getUnitTypeId();
        this.cost = data.getCost();
        this.price = data.getPrice();
        this.status = Constants.ACTIVE_STATUS;
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

    public void setUpdate(ProductUnitReq data){
        this.id = data.getId();
        this.productId = data.getProductId();
        this.unitTypeId = data.getUnitTypeId();
        this.cost = data.getCost();
        this.price = data.getPrice();
        this.status = Constants.ACTIVE_STATUS;
        this.setUpdateAt(new Date());
        this.setUpdateBy(Constants.APP);
    }


}
