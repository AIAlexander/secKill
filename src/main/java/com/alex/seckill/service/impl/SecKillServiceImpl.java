package com.alex.seckill.service.impl;

import com.alex.seckill.common.Response;
import com.alex.seckill.dao.OrderDao;
import com.alex.seckill.domain.OrderInfo;
import com.alex.seckill.domain.SecondKillOrder;
import com.alex.seckill.service.GoodService;
import com.alex.seckill.service.SecKillOrderService;
import com.alex.seckill.service.SecKillService;
import com.alex.seckill.vo.GoodVO;

import com.alex.seckill.vo.OrderInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wsh
 * @date 2021-04-28
 */
@Service
@Slf4j
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private GoodService goodService;

    @Autowired
    private SecKillOrderService secKillOrderService;


    /**
     * 秒杀的逻辑：
     *  1。判断库存是否小于0
     *  2。判断用户是否已经进行过商品的秒杀
     *  3。减库存，添加订单，写入秒杀订单中
     * @return
     */
    @Override
    @Transactional
    public Response secKill(Long goodId, Long userId) {

        //判断库存是否小于0
        //根据goodId查找秒杀商品的信息
        GoodVO goodVO = goodService.getGoodVOById(goodId);
        if(goodVO == null) {
            return Response.GOOD_NOT_FOUND();
        }
        if(goodVO.getStockCount() <= 0) {
            //库存小于0，秒杀失败
            return Response.SECKILL_OVER();
        }
        //判断用户是否已经进行过该商品的秒杀
        List<SecondKillOrder> orderList = secKillOrderService.getSecondKillOrderByGoodIdAndUserId(goodId, userId);
        if(orderList != null && orderList.size() >= 1) {
            //如果已经秒杀过的，就返回重复秒杀的错误
            return Response.SECKILL_REPEAT();
        }
        OrderInfo orderInfo = doSecKill(goodVO, userId);
        if(orderInfo == null) {
            return Response.ORDER_NOT_FOUND();
        }
        return Response.SUCCESS(new OrderInfoVO(orderInfo, goodVO));
    }

    public OrderInfo doSecKill(GoodVO goodVO, Long userId){
        //减库存，添加订单，写入秒杀订单中
        //减少库存
        goodService.reduceSecKillGoodStock(goodVO.getId());
        //生成订单，orderInfo（普通订单）与SecKillOrderInfo（秒杀订单）
        return secKillOrderService.createSecKillOrder(goodVO, userId);
    }
}
