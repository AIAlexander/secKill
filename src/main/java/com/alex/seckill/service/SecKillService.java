package com.alex.seckill.service;

import com.alex.seckill.common.Response;

/**
 * @author wsh
 * @date 2021-04-28
 *
 * 秒杀服务接口
 */
public interface SecKillService {

    Response secKill(Long goodId, Long userId);
}
