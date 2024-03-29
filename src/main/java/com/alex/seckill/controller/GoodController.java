package com.alex.seckill.controller;

import com.alex.seckill.common.Constants;
import com.alex.seckill.domain.User;
import com.alex.seckill.service.GoodService;
import com.alex.seckill.service.UserService;
import com.alex.seckill.service.impl.UserServiceImpl;
import com.alex.seckill.vo.GoodVO;
import com.alex.seckill.vo.SecKillGoodDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author wsh
 * @date 2020-09-09
 */
@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodService goodService;

    @GetMapping("/to-good-list")
    public String toGoodList(Model model, User user){
        model.addAttribute("user", user);
        return "goods-list";
    }

    @GetMapping("/list")
    public String list(Model model, User user){
        model.addAttribute("user", user);
        List<GoodVO> goodVOList = goodService.getGoodVOList();
        model.addAttribute("goodList", goodVOList);
        return "goods-list";
    }

    @GetMapping("/to_detail/{goodsId}")
    public String list(Model model, User user, @PathVariable("goodsId") Long goodsId){
        model.addAttribute("user", user);
        SecKillGoodDetailVO goodDetailVO = goodService.getSecKillGoodDetailVOById(goodsId);
        model.addAttribute("goodDetail", goodDetailVO);
        return "goods-detail";
    }
}
