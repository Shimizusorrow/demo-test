package com.unfrost.common.base.entity;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-07 14:52
 */
public enum LifeState {
    /**
     * 实体状态
     */
    RUNNING("活动状态"),
    PAUSED("暂停状态"),
    FREEZING("冻结状态"),
    STOPPED("停止状态");

    private String chinese;

    LifeState(String chinese) {
        this.chinese = chinese;
    }
}
