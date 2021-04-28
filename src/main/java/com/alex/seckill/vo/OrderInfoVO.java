package com.alex.seckill.vo;

import com.alex.seckill.domain.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wsh
 * @date 2021-04-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoVO {

    private OrderInfo orderInfo;

    private GoodVO goodVO;
}
