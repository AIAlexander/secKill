package com.alex.seckill.dao;

import com.alex.seckill.vo.GoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author wsh
 * @date 2020-09-24
 */
@Mapper
@Component
public interface GoodDao {

    @Select("select g.*, skg.stock_count, skg.price, skg.start_date, skg.end_date" +
            " from good g left join second_kill_good skg on g.id = skg.good_id")
    List<GoodVO> getGoodVOList();

    @Select("select g.*, skg.stock_count, skg.price, skg.start_date, skg.end_date" +
            " from good g left join second_kill_good skg on g.id = skg.good_id where g.id = #{goodId}")
    GoodVO getGoodVOById(@Param("goodId") Long goodId);

    @Update("update second_kill_good skg set skg.stock_count = skg.stock_count - 1 where skg.good_id = #{goodId}")
    int reduceSecKillGoodStock(Long goodId);
}
