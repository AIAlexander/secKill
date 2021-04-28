package com.alex.seckill.controller;

import com.alex.seckill.common.Response;
import com.alex.seckill.domain.User;
import com.alex.seckill.redis.RedisService;
import com.alex.seckill.redis.util.UserKey;
import com.alex.seckill.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wsh
 * @date 2020-09-01
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "alex");
        return "hello";
    }

    @GetMapping("/server-error")
    @ResponseBody
    public Response serverError(){
        return Response.SUCCESS("正确");
    }

    @GetMapping("/test-db-get")
    @ResponseBody
    public Response getUser(){
        User user = userService.getUserById(1);
        return Response.SUCCESS(user);
    }

    @PostMapping("/test-tx")
    @ResponseBody
    public Response testTx(){
        userService.testTx();
        return Response.SUCCESS(null);
    }

    @GetMapping("/test-redis-get")
    @ResponseBody
    public Response testRedisGet(){
        User u1 = redisService.get(UserKey.USER_ID, "1", User.class);
        return Response.SUCCESS(u1);
    }

    @PostMapping("/test-redis-set")
    @ResponseBody
    public Response testRedisSet(){
        User user = new User();
//        user.setId(1);
        user.setName("alex");
        boolean flag = redisService.set(UserKey.USER_ID,String.valueOf(user.getId()), user);
        return Response.SUCCESS(flag);
    }

}
