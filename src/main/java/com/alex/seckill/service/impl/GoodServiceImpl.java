package com.alex.seckill.service.impl;

import com.alex.seckill.dao.GoodDao;
import com.alex.seckill.service.GoodService;
import com.alex.seckill.vo.GoodVO;
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
    public List<GoodVO> getGoodVOList() {
        return goodDao.getGoodVOList();
    }
}
