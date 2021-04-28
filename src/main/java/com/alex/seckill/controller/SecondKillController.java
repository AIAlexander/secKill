package com.alex.seckill.controller;

import com.alex.seckill.common.Response;
import com.alex.seckill.domain.OrderInfo;
import com.alex.seckill.domain.User;
import com.alex.seckill.service.SecKillService;
import com.alex.seckill.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wsh
 * @date 2021-04-28
 */

@Controller
@RequestMapping("sec_kill")
public class SecondKillController {

    @Autowired
    private SecKillService secKillService;

    @PostMapping
    public String secKill(Model model, User user, @RequestParam("goodId") Long goodId){
        if(user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        Response response = secKillService.secKill(goodId, user.getId());
        if(response.getCode() != 0) {
            model.addAttribute("error_msg", response.getMsg());
            return "sec_kill_fail";
        }
        model.addAttribute("orderInfo", (OrderInfoVO) response.getData());
        //秒杀服务
        return "order_detail";
    }
}
