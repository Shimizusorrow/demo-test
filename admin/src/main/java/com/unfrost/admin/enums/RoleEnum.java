package com.unfrost.admin.enums;

/**
 * @author Shimizu
 * @description 权限
 * @date 2021-04-07 16:50
 */
public enum RoleEnum {
    /**
     * 权限
     */
    SUPER_ADMIN("超级管理员"),
    ADMIN("管理员"),
    NORMAL("普通用户");
    private final String chinese;

    RoleEnum(String chinese) {
        this.chinese = chinese;
    }

    public String getChinese() {
        return chinese;
    }
}
