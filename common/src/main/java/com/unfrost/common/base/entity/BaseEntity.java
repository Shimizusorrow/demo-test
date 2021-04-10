package com.unfrost.common.base.entity;

import javax.persistence.*;

/**
 * 基础实体类型
 *
 * @author Shimizu
 * @description
 * @date 2021-04-07 14:44
 */
@MappedSuperclass
public class BaseEntity extends BaseId {
    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 实体状态
     */
    @Enumerated(EnumType.STRING)
    private LifeState lifeState;

    /**
     * 用于修改本次实体是否更新 更新时间
     */
    @Transient
    private boolean changeCondition = true;

    /**
     * @PrePersist 帮助您在持久化之前自动填充实体属性
     * <p>
     * 初始化创建时间和更新时间
     */
    @PrePersist
    public void prePersist() {
        long time = System.currentTimeMillis();
        this.createTime = time;
        this.updateTime = time;
        this.lifeState = LifeState.RUNNING;
    }

    /**
     * @PreUpdate 用于为相应的生命周期事件指定回调方法。
     */
    @PreUpdate
    public void preUpDate() {
        if (changeCondition) {
            this.updateTime = System.currentTimeMillis();
        } else {
            changeCondition = true;
        }
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public LifeState getLifeState() {
        return lifeState;
    }

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
    }

    public boolean isChangeCondition() {
        return changeCondition;
    }

    public void setChangeCondition(boolean changeCondition) {
        this.changeCondition = changeCondition;
    }

    public BaseEntity(String id) {
        super(id);
    }

    public BaseEntity() {
        super();
    }

    public boolean isRunning() {
        return LifeState.RUNNING.equals(lifeState);
    }

    public boolean isStopped() {
        return LifeState.STOPPED.equals(lifeState);
    }

    public LifeState beRunning() {
        lifeState = LifeState.RUNNING;
        return lifeState;
    }

    public LifeState beStopped() {
        lifeState = LifeState.STOPPED;
        return lifeState;
    }
}
