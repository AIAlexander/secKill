package com.alex.seckill.service.impl;

import com.alex.seckill.dao.SecKillOrderDao;
import com.alex.seckill.domain.OrderInfo;
import com.alex.seckill.domain.SecondKillOrder;
import com.alex.seckill.service.OrderService;
import com.alex.seckill.service.SecKillOrderService;
import com.alex.seckill.service.SecKillService;
import com.alex.seckill.vo.GoodVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wsh
 * @date 2021-04-28
 *
 * 秒杀服务订单相关实现类
 */
@Service
@Slf4j
public class SecKillOrderServiceImpl implements SecKillOrderService {

    @Autowired
    private SecKillOrderDao secKillOrderDao;

    @Autowired
    private OrderService orderService;


    @Override
    public List<SecondKillOrder> getSecondKillOrderByGoodIdAndUserId(Long goodId, Long userId) {
        return secKillOrderDao.getSecondKillOrderByGoodIdAndUserId(goodId, userId);
    }

    @Override
    public OrderInfo createSecKillOrder(GoodVO goodVO, Long userId) {
        //生成普通订单 orderInfo
        OrderInfo orderInfo = orderService.createOrderInfo(goodVO, userId);
        if(orderInfo != null) {
            //创建秒杀订单 second_kill_order_info
            secKillOrderDao.createSecKillOrderInfo(goodVO.getId(), userId, orderInfo.getId());
        }
        return orderInfo;
    }
}
