package com.alex.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author wsh
 * @date 2020-09-05
 */
public class MD5Utils {

    private static final String SALT = "ALEX";

    public static String md5(String s){
        return DigestUtils.md5Hex(s);
    }

    /**
     * 前端到后端的第一次加密
     * @param pass
     * @return
     */
    public static String md5PassFromFront(String pass){
        String temp = "" + SALT.charAt(0) + SALT.charAt(1) + pass + SALT.charAt(2) + SALT.charAt(3);
        System.out.println(temp);
        return md5(temp);
    }

    /**
     * 第二次加密，输出保存到数据库中
     * @param pass
     * @param salt
     * @return
     */
    public static String md5PassToEnd(String pass, String salt){
        String temp = salt + pass;
        return md5(temp);
    }

    /**
     * 第一次+第二次加密
     * @param pass
     * @param salt
     * @return
     */
    public static String md5PassFromFrontToEnd(String pass, String salt){
        return md5PassToEnd(md5PassFromFront(pass), salt);
    }

    public static void main(String[] args) {
        System.out.println(md5PassFromFrontToEnd("123456", "12345"));
//        System.out.println(md5PassFromFront("123456"));
//        System.out.println(md5("AL123456EX"));
    }
}
