package com.alex.seckill.redis.util;

/**
 * @author wsh
 * @date 2020-09-05
 */
public interface KeyPrefix {

    int getExpireTime();

    String generateKeyPrefix();

}
