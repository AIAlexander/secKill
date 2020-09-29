package com.alex.seckill.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wsh
 * @date 2020-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private Long id;
    private String goodName;
    private String goodTitle;
    private String goodImage;
    private String goodDetail;
    private Integer goodStock;
    private BigDecimal goodPrice;
}
