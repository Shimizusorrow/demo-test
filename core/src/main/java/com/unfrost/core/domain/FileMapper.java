package com.unfrost.core.domain;

import com.unfrost.common.base.entity.BaseEntity;
import com.unfrost.core.enums.FileEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 14:39
 */
@ApiModel("上传文件的映射实体")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class FileMapper extends BaseEntity {
    /**
     * 文件原来的名称
     */
    @ApiModelProperty("文件原来的名称")
    private String realName;
    /**
     * 文件映射的名称
     */
    @ApiModelProperty("映射后文件的名称")
    private String mapperName;

    @ApiModelProperty("文件类型")
    @Enumerated(EnumType.STRING)
    private FileEnum category;

    public FileMapper(String id, String realName, String mapperName, FileEnum category) {
        super(id);
        this.realName = realName;
        this.mapperName = mapperName;
        this.category = category;
    }
}
