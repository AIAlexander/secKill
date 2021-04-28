package com.alex.seckill.dao;

import com.alex.seckill.domain.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

/**
 * @author wsh
 * @date 2021-04-28
 */
@Mapper
@Component
public interface OrderDao {


    @Insert("insert into order_info (user_id, good_id, good_name, good_count, good_price, order_source, status, create_date) values (" +
            "#{userId}, #{goodId}, #{goodName}, #{goodCount}, #{goodPrice}, #{orderSource}, #{status}, #{createDate} )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long createOrder(OrderInfo orderInfo);
}
