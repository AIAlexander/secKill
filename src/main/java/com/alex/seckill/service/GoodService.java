package com.alex.seckill.service;

import com.alex.seckill.vo.GoodVO;
import com.alex.seckill.vo.SecKillGoodDetailVO;

import java.util.List;

/**
 * @author wsh
 * @date 2020-09-24
 */
public interface GoodService {

    GoodVO getGoodVOById(Long goodId);

    List<GoodVO> getGoodVOList();

    SecKillGoodDetailVO getSecKillGoodDetailVOById(Long goodId);

    void reduceSecKillGoodStock(Long goodId);
}
