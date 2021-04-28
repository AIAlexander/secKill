package com.alex.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wsh
 * @date 2021-04-28
 *
 * 秒杀商品的详细信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecKillGoodDetailVO{

    //商品详细信息
    private GoodVO goodVO;

    //秒杀活动的状态（未开始，进行中，已结束）
    private Integer seckKillStatus;

    //距离秒杀活动还剩几秒开始
    private Integer remainSecond;

}
