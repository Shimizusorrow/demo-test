package com.unfrost.admin.enums;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-07 16:45
 */
public enum GenderEnum {
    /**
     * 性别
     */
    MALE("男士"),
    FEMALE("女士");
    private final String chinese;

    GenderEnum(String chinese) {
        this.chinese = chinese;
    }

    public String getChinese() {
        return chinese;
    }
}
