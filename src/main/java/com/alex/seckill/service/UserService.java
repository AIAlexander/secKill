package com.alex.seckill.service;

import com.alex.seckill.common.Response;
import com.alex.seckill.domain.User;
import com.alex.seckill.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author wsh
 * @date 2020-09-03
 */
@Service
public interface UserService {

    User getUserById(int id);

    void testTx();

    User getUserByPhone(String phone);

    Response login(UserVO userVO);
}
