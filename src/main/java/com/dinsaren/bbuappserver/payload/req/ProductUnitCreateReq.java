package com.dinsaren.bbuappserver.payload.req;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
public class ProductUnitCreateReq {
    private int id;
    private int productId;
    private Integer unitTypeId;
    private BigDecimal cost;
    private BigDecimal price;
    private String status;

}
