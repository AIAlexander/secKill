package com.alex.seckill.dao;

import com.alex.seckill.vo.GoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    public List<GoodVO> getGoodVOList();
}
