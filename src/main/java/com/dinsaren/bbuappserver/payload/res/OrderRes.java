package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.models.Order;
import com.dinsaren.bbuappserver.utils.BaseEntityRes;
import com.dinsaren.bbuappserver.utils.DecimalFormatter;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderRes extends BaseEntityRes {
    private int id;
    private Integer customerId;
    private PeopleRes customer;
    private String date;
    private String orderDate;
    private BigDecimal deposit;
    private BigDecimal discount;
    private BigDecimal 	amount;
    private String formatDeposit;
    private String formatDiscount;
    private String 	formatAmount;
    private String 	status;
    private Integer totalItems;

    public void setDataRes(Order data, PeopleRes peopleRes, Integer itemsCount){
        this.id=data.getId();
        this.customerId=data.getCustomerId();
        this.customer=peopleRes==null ? new PeopleRes() : peopleRes;
        this.date=data.getDate().toString();
        this.orderDate=data.getOrderDate().toString();
        this.deposit=data.getDeposit();
        this.discount=data.getDiscount();
        this.amount=data.getAmount();
        this.formatDeposit = DecimalFormatter.formatUsdDigi(data.getDeposit());
        this.formatDiscount = DecimalFormatter.formatUsdDigi(data.getDiscount());
        this.formatAmount = DecimalFormatter.formatUsdDigi(data.getAmount());
        this.status = data.getStatus();
        this.totalItems = itemsCount;

    }

}
