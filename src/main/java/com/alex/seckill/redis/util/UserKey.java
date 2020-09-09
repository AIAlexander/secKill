package com.alex.seckill.redis.util;

/**
 * @author wsh
 * @date 2020-09-05
 */
public class UserKey extends BaseKey{

    private int expireTime = 24 * 3600 * 2;

    private UserKey(String module, String prefix) {
        super(module, prefix);
    }

    private UserKey(String module, String prefix, int expireTime){
        super(module, prefix);
        this.expireTime = expireTime;
    }

    public static UserKey USER_ID = new UserKey("USER", "ID");
    public static UserKey USER_NAME = new UserKey("USER", "NAME");
    public static UserKey USER_TOKEN = new UserKey("USER", "TOKEN");

    @Override
    public int getExpireTime() {
        return expireTime;
    }
}
