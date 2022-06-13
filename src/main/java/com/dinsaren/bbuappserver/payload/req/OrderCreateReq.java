package com.dinsaren.bbuappserver.payload.req;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderCreateReq{
    private int id;
    private Integer customerId;
    private Date date;
    private Date orderDate;
    private BigDecimal deposit;
    private BigDecimal discount;
    private BigDecimal 	amount;
    private String 	status;
    private List<OrderDetailCreateReq> orderItems;
    
}
