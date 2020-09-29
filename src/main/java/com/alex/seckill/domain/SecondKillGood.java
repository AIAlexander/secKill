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
public class SecondKillGood {
    private Long id;
    private Long goodId;
    private BigDecimal price;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
