package com.unfrost.core.enums;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 15:02
 */
public enum FileEnum {
    /**
     * 文件类型
     */
    IMAGE("图片"),
    VIDEO("视屏"),
    FILE("普通文件");
    private String chinese;

    FileEnum(String chinese) {
        this.chinese = chinese;
    }

    public String getChinese() {
        return chinese;
    }
}
