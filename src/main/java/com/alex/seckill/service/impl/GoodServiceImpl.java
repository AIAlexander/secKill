package com.alex.seckill.service.impl;

import com.alex.seckill.constant.SecKillStatusEnum;
import com.alex.seckill.dao.GoodDao;
import com.alex.seckill.service.GoodService;
import com.alex.seckill.vo.GoodVO;
import com.alex.seckill.vo.SecKillGoodDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wsh
 * @date 2020-09-24
 */
@Service
@Slf4j
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public GoodVO getGoodVOById(Long goodId) {
        return goodDao.getGoodVOById(goodId);
    }

    @Override
    public List<GoodVO> getGoodVOList() {
        return goodDao.getGoodVOList();
    }

    @Override
    public SecKillGoodDetailVO getSecKillGoodDetailVOById(Long goodId) {
        SecKillGoodDetailVO secKillGoodDetailVO = new SecKillGoodDetailVO();
        if(goodId != null) {
            GoodVO goodVO = getGoodVOById(goodId);
            if(goodVO != null) {
                //获取秒杀活动的状态
                long startAt = goodVO.getStartDate().getTime();
                long endAt = goodVO.getEndDate().getTime();
                long now = System.currentTimeMillis();
                int secKillStatus = 0;
                int remainTime = 0;
                if(now < startAt) {
                    //活动未开始
                    secKillStatus = SecKillStatusEnum.NOT_START.getStatus();
                    //计算倒计时时间(以秒为单位)
                    remainTime = (int)((startAt - now) / 1000);
                }else if(now < endAt) {
                    //活动进行中
                    secKillStatus = SecKillStatusEnum.STARTING.getStatus();
                    remainTime = 0;
                }else {
                    //活动已结束
                    secKillStatus = SecKillStatusEnum.FINISH.getStatus();
                    remainTime = -1;
                }
                secKillGoodDetailVO.setSeckKillStatus(secKillStatus);
                secKillGoodDetailVO.setRemainSecond(remainTime);
            }
            secKillGoodDetailVO.setGoodVO(goodVO);
        }
        return secKillGoodDetailVO;
    }

    @Override
    public void reduceSecKillGoodStock(Long goodId) {
        //减少秒杀商品的库存
        goodDao.reduceSecKillGoodStock(goodId);
        //TODO 还需要减少商品的库存
    }
}
