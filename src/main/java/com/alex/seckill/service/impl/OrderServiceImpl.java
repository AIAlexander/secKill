package com.alex.seckill.service.impl;

import com.alex.seckill.constant.OrderStatusEnum;
import com.alex.seckill.dao.OrderDao;
import com.alex.seckill.domain.OrderInfo;
import com.alex.seckill.service.OrderService;
import com.alex.seckill.vo.GoodVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wsh
 * @date 2021-04-28
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public OrderInfo createOrderInfo(GoodVO goodVO, Long userId) {
        //生成订单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddressId(0L);
        orderInfo.setGoodCount(1);
        orderInfo.setGoodId(goodVO.getId());
        orderInfo.setGoodName(goodVO.getGoodName());
        orderInfo.setGoodPrice(goodVO.getPrice());
        orderInfo.setOrderSource(1);
        orderInfo.setStatus(OrderStatusEnum.NEW.getStatus());
        orderInfo.setUserId(userId);
        long orderId = orderDao.createOrder(orderInfo);
        return orderInfo;
    }
}
