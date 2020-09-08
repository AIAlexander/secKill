package com.alex.seckill.exception;

/**
 * @author wsh
 * @date 2020-09-08
 */
public class BusinessException extends RuntimeException {

    private int code = 50010;

    public BusinessException(int code, String msg){
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
