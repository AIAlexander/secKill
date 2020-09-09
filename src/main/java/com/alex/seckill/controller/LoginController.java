package com.alex.seckill.controller;

import com.alex.seckill.common.Response;
import com.alex.seckill.service.UserService;
import com.alex.seckill.util.ValidatorUtil;
import com.alex.seckill.vo.UserVO;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author wsh
 * @date 2020-09-05
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String toLogin(){
        return "login";
    }

    @PostMapping
    @ResponseBody
    public Response login(HttpServletResponse response, @Valid UserVO userVO){
        log.info("Login: {}", JSON.toJSONString(userVO));
        //参数校验
//        String password = userVO.getPassword();
//        String phone = userVO.getPhone();
//        if(StringUtils.isEmpty(password)){
//            return Response.PASSWORD_EMPTY();
//        }
//        if(StringUtils.isEmpty(phone)){
//            return Response.PHONE_EMPTY();
//        }
//        if(!ValidatorUtil.isPhone(phone)){
//            return Response.PHONE_FORMAT_ERROR();
//        }
        //登录
        return userService.login(response, userVO);
    }
}
