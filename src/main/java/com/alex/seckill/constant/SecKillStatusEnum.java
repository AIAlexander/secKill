package com.alex.seckill.constant;

/**
 * @author wsh
 * @date 2021-04-28
 */
public enum  SecKillStatusEnum {

    NOT_START(0, "未开始"),
    STARTING(1, "进行中"),
    FINISH(-1, "已结束")
    ;


    //秒杀活动状态的编码
    private int status;

    //秒杀活动状态名称
    private String name;

    SecKillStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

}
