package com.unfrost.common.base.entity;

import javax.persistence.MappedSuperclass;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:27
 */
@MappedSuperclass
public class BaseEntry extends BaseEntity {
    public static final String PARENT_ID = "parent_id";
}
