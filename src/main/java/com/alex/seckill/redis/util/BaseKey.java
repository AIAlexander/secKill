package com.alex.seckill.redis.util;

/**
 * @author wsh
 * @date 2020-09-05
 */
public abstract class BaseKey implements KeyPrefix {

    private int expireTime;

    private String module;

    private String prefix;

    public BaseKey(int expireTime, String module, String prefix){
        this.expireTime = expireTime;
        this.module = module;
        this.prefix = prefix;
    }

    public BaseKey(String module, String prefix){
        this.module = module;
        this.prefix = prefix;
    }

    @Override
    public int getExpireTime() {
        return 0;
    }

    @Override
    public String generateKeyPrefix(){
        return this.module + ":" + prefix + ":";
    }
}
