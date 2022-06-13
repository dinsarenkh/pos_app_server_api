package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.ProductUnit;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUnitRes extends BaseEntityRes {
    private int id;
    private int productId;
    private ProductRes productRes;
    private Integer unitTypeId;
    protected UnitTypeRes unitTypeRes;
    private BigDecimal cost;
    private BigDecimal price;
    private String status;

    public void setDateRes(ProductUnit data, ProductRes productRes, UnitTypeRes unitTypeRes){
        this.id = data.getId();
        this.productId = data.getProductId();
        this.unitTypeId = data.getUnitTypeId();
        this.cost = data.getCost();
        this.price = data.getPrice();
        this.productRes = productRes == null ? new ProductRes() : productRes;
        this.unitTypeRes = unitTypeRes==null ? new UnitTypeRes() : unitTypeRes;
        this.unitTypeId = data.getUnitTypeId();
        this.setCreateAt(data.getCreateAt());
        this.setCreateBy(data.getCreateBy());
        this.setUpdateAt(data.getUpdateAt());
        this.setUpdateBy(data.getUpdateBy());

    }

}
