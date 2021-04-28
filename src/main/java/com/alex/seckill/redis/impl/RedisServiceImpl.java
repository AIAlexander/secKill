package com.alex.seckill.redis.impl;

import com.alex.seckill.redis.RedisConfig;
import com.alex.seckill.redis.RedisService;
import com.alex.seckill.redis.util.BaseKey;
import com.alex.seckill.redis.util.KeyPrefix;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author wsh
 * @date 2020-09-03
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    JedisPool jedisPool;

    @Autowired
    RedisConfig redisConfig;



    @Override
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.generateKeyPrefix() + key;
            String str = jedis.get(realKey);
            return valueToBean(str, clazz);
        }catch (Exception e){
            e.printStackTrace();
           log.error("Jedis get Error!");
        }finally {
            returnToPool(jedis);
        }
        return null;
    }

    @Override
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.generateKeyPrefix() + key;
            String str = beanToValue(value);
            if(StringUtils.isEmpty(str)){
                return false;
            }
            int expireTime = prefix.getExpireTime();
            if(expireTime <= 0){
                jedis.set(realKey, str);  //永不过期
            }else{
                jedis.setex(realKey, expireTime, str);
            }
            return true;
        }catch (Exception e){
            log.error("Jedis get Error!");
            return false;
        }finally {
            returnToPool(jedis);
        }
    }

    @Override
    public <T> boolean exists(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.generateKeyPrefix() + key;
            return jedis.exists(realKey);
        }catch (Exception e){
            log.error("Jedis get Error!");
            return false;
        }finally {
            returnToPool(jedis);
        }
    }

    @Override
    public <T> Long incr(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.generateKeyPrefix() + key;
            return jedis.incr(realKey);
        }catch (Exception e){
            log.error("Jedis get Error!");
            return null;
        }finally {
            returnToPool(jedis);
        }
    }

    @Override
    public <T> Long decr(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = prefix.generateKeyPrefix() + key;
            return jedis.decr(realKey);
        }catch (Exception e){
            log.error("Jedis get Error!");
            return null;
        }finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToValue(T value) {
        if(value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class){
            return ""+value;
        }else if(clazz == String.class){
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class){
            return ""+value;
        }else{
            return JSON.toJSONString(value);
        }
    }

    private <T> T valueToBean(String str, Class<T> clazz){
        if(StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        if(clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(str);
        }else{
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    private void returnToPool(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }
}
