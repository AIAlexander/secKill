package com.alex.seckill.dao;

import com.alex.seckill.domain.SecondKillOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wsh
 * @date 2021-04-28
 */
@Mapper
@Component
public interface SecKillOrderDao {


    @Select("select id, good_id, user_id, order_id from second_kill_order where user_id = #{userId} and good_id = #{goodId}")
    List<SecondKillOrder> getSecondKillOrderByGoodIdAndUserId(@Param("goodId") Long goodId, @Param("userId") Long userId);

    @Insert("insert into second_kill_order(good_id, user_id, order_id) values (#{goodId}, #{userId}, #{orderId})")
    void createSecKillOrderInfo(@Param("goodId") Long goodId, @Param("userId") Long userId, @Param("orderId") Long orderId);
}
