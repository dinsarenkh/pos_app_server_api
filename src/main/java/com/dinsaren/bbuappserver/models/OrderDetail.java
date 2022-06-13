package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.OrderCreateReq;
import com.dinsaren.bbuappserver.payload.req.OrderDetailCreateReq;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pos_order_details")
@Entity
@Data
public class OrderDetail extends BaseEntityRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "order_id")
    public Integer orderId;
    @Column(name = "product_id")
    public Integer productId;
    @Column(name = "unit_type_id")
    public Integer unitTypeId;
    @Column(name = "qty")
    public Double qty;
    @Column(name = "price")
    public BigDecimal price;
    @Column(name = "discount")
    public BigDecimal discount;
    public String status;

    public void setCreate(OrderDetailCreateReq data, Integer orderId){
        this.orderId =orderId;
        this.productId = data.getProductId();
        this.unitTypeId = data.getUnitTypeId();
        this.qty = data.getQty();
        this.price = data.getPrice();
        this.discount = data.getDiscount();
        this.status = Constants.ACTIVE_STATUS;
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

}
