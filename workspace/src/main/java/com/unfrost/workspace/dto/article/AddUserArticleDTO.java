package com.unfrost.workspace.dto.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 15:18
 */
@Data
public class AddUserArticleDTO {
    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    private String content;
}
