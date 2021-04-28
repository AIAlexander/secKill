package com.alex.seckill.constant;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author wsh
 * @date 2021-04-28
 *
 * 订单状态 0-新建未支付 1-已支付 2-已发货 3-已收货 4-已退款 5-已完成
 */
public enum  OrderStatusEnum {

    NEW(0, "新建未支付"),
    PAYED(1, "已支付"),
    TRANSPORT(2, "已发货"),
    RECEIVE(3, "已收货"),
    REFUND(4, "已退款"),
    FINISH(5, "已完成");

    private int status;

    private String des;

    OrderStatusEnum(int status, String des) {
        this.status = status;
        this.des = des;
    }

    public int getStatus() {
        return status;
    }

    public String getDes() {
        return des;
    }
}
