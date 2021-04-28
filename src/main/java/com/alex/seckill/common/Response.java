package com.alex.seckill.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wsh
 * @date 2020-09-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private int code;
    private String msg;
    private Object data;

    public static Response SUCCESS(Object data){
        return new Response(0, "success", data);
    }

    public static Response BUSINESS_EXCEPTION(int code, String msg){
        return new Response(code, msg, null);
    }

    public static Response SERVER_ERROR(){
        return new Response(50010, "服务器异常", null);
    }
    public static Response BIND_EXCEPTION(String msg) {
        return new Response(50010, "参数校验失败！" + msg, null);
    }

    public static Response LOGIN_ERROR(){
        return new Response(50020, "登录异常", null);
    }

    public static Response PASSWORD_EMPTY(){
        return new Response(50020, "登录异常，密码不能为空！", null);
    }
    public static Response PHONE_EMPTY(){
        return new Response(50020, "登录异常，手机号不能为空！", null);
    }
    public static Response PHONE_FORMAT_ERROR(){
        return new Response(50020, "登录异常，手机号格式错误！", null);
    }
    public static Response PHONE_NOT_EXIST(){
        return new Response(50020, "登录异常，手机号不存在", null);
    }
    public static Response PASSWORD_ERROR(){
        return new Response(50020, "登录异常，密码错误", null);
    }

    public static Response GOOD_NOT_FOUND(){
        return new Response(50030, "商品不存在", null);
    }

    public static Response ORDER_ERROR(){
        return new Response(50040, "订单异常", null);
    }
    public static Response ORDER_NOT_FOUND(){
        return new Response(50040, "订单不存在", null);
    }

    public static Response SECKILL_ERROR(){
        return new Response(50050, "秒杀异常", null);
    }
    public static Response SECKILL_OVER(){
        return new Response(50050, "秒杀已经结束", null);
    }
    public static Response SECKILL_REPEAT(){
        return new Response(50050, "不能够重新秒杀", null);
    }
}
