package com.dinsaren.bbuappserver.payload.req;

import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
public class OrderDetailCreateReq extends BaseEntityRes {
    public int id;
    public Integer orderId;
    public Integer productId;
    public Integer unitTypeId;
    public Double qty;
    public BigDecimal price;
    public BigDecimal discount;
    public String status;

}
