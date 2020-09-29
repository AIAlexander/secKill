package com.alex.seckill.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wsh
 * @date 2020-09-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondKillOrder {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodId;
}
