package com.unfrost.common.dto;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 15:26
 */
public abstract class BaseUpdateDto {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
