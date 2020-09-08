package com.alex.seckill.redis.util;

/**
 * @author wsh
 * @date 2020-09-05
 */
public class UserKey extends BaseKey{

    private UserKey(String module, String prefix) {
        super(module, prefix);
    }

    public static UserKey USER_ID = new UserKey("USER", "ID");
    public static UserKey USER_NAME = new UserKey("USER", "NAME");

}
