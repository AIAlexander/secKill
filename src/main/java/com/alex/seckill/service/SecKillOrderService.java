package com.alex.seckill.service;

import com.alex.seckill.domain.OrderInfo;
import com.alex.seckill.domain.SecondKillOrder;
import com.alex.seckill.vo.GoodVO;

import java.util.List;

/**
 * @author wsh
 * @date 2021-04-28
 *
 * 秒杀订单的相关服务
 */
public interface SecKillOrderService {

    List<SecondKillOrder> getSecondKillOrderByGoodIdAndUserId(Long goodId, Long userId);

    OrderInfo createSecKillOrder(GoodVO goodVO, Long userId);
}
