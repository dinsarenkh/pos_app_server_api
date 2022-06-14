package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.payload.req.OrderCreateReq;
import com.dinsaren.bbuappserver.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pos_orders")
@Entity
@Data
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "date")
    private Date date;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "deposit")
    private BigDecimal deposit;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "amount")
    private BigDecimal 	amount;
    private String status;
    @Column(name = "outlet_id")
    private Integer outletId;

    public void setCreate(OrderCreateReq data){
        this.customerId = data.getCustomerId();
        this.orderDate = data.getOrderDate();
        this.date = data.getDate();
        this.deposit = data.getDeposit();
        this.deposit = data.getDiscount();
        this.amount = data.getAmount();
        this.status = Constants.ACTIVE_STATUS;
        this.setCreateAt(new Date());
        this.setCreateBy(Constants.APP);
    }

}
