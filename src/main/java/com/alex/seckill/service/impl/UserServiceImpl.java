package com.alex.seckill.service.impl;

import com.alex.seckill.common.Response;
import com.alex.seckill.dao.UserDao;
import com.alex.seckill.domain.User;
import com.alex.seckill.exception.BusinessException;
import com.alex.seckill.service.UserService;
import com.alex.seckill.util.MD5Utils;
import com.alex.seckill.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wsh
 * @date 2020-09-03
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void testTx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("aaaaa");
        userDao.saveUser(u1);

        User u2 = new User();
        u2.setId(2);
        u2.setName("bbbb");
        userDao.saveUser(u2);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public Response login(UserVO userVO) {
        if(userVO == null){
            throw new BusinessException(50020, "上传的参数不能为空！");
        }
        String phone = userVO.getPhone();
        String password = userVO.getPassword();
        //判断手机号是否存在
        User user = userDao.getUserByPhone(phone);
        if(user == null){
            throw new BusinessException(50020, "用户不存在！");
        }
        String salt = user.getSalt();
        String truePass = user.getPassword();
        String md5Pass = MD5Utils.md5PassToEnd(password, salt);
        if(!StringUtils.equals(truePass, md5Pass)){
            throw new BusinessException(50020, "密码错误！");
        }
        return Response.SUCCESS(true);
    }


}
