package com.alex.seckill.vo;

import com.alex.seckill.domain.Good;
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
public class GoodVO extends Good {
    private BigDecimal price;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
