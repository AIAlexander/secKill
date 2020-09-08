package com.alex.seckill.exception;

import com.alex.seckill.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wsh
 * @date 2020-09-08
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Response globalException(HttpServletRequest request, Exception e){
        log.error("Exception: {}", e);
        if(e instanceof BindException){
            BindException ex = (BindException) e;
            ObjectError error = ex.getAllErrors().get(0);
            String msg = error.getDefaultMessage();
            return Response.BIND_EXCEPTION(msg);
        }else if(e instanceof BusinessException){
            BusinessException ex = (BusinessException) e;
            return Response.BUSINESS_EXCEPTION(ex.getCode(), ex.getMessage());
        }
        //TODO 暂时不捕捉其他错误
        else{
            return Response.SERVER_ERROR();
        }
    }
}
