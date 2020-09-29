package com.alex.seckill.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wsh
 * @date 2020-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private Long id;
    private Long userId;
    private Long goodId;
    private Long deliveryAddressId;
    private String goodName;
    private Integer goodCount;
    private BigDecimal goodPrice;
    private Integer orderSource;
    private Integer status;
    private Date createDate;
    private Date payDate;
}
