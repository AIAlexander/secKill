package com.alex.seckill.util;

import java.util.UUID;

/**
 * @author wsh
 * @date 2020-09-09
 */
public class UUIDUtils {

    public static String genernateUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
