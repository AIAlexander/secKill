package com.alex.seckill.redis;

import com.alex.seckill.redis.util.KeyPrefix;

/**
 * @author wsh
 * @date 2020-09-03
 */
public interface RedisService {

    <T> T get(KeyPrefix prefix, String key, Class<T> clazz);

    <T> boolean set(KeyPrefix prefix, String key, T value);

    <T> boolean exists(KeyPrefix prefix, String key, T value);

    <T> Long incr(KeyPrefix prefix, String key, T value);

    <T> Long decr(KeyPrefix prefix, String key, T value);

}
