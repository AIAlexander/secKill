package com.alex.seckill.service;

import com.alex.seckill.domain.Good;
import com.alex.seckill.domain.OrderInfo;
import com.alex.seckill.vo.GoodVO;

/**
 * @author wsh
 * @date 2021-04-28
 */
public interface OrderService {

    OrderInfo createOrderInfo(GoodVO goodVO, Long userId);
}
