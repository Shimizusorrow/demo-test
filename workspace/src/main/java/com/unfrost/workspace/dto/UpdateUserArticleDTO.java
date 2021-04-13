package com.unfrost.workspace.dto;

import com.unfrost.common.dto.BaseUpdateDto;
import com.unfrost.workspace.domain.article.UserComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 修改文章
 *
 * @author Shimizu
 * @description
 * @date 2021-04-13 15:24
 */
@Data
public class UpdateUserArticleDTO extends BaseUpdateDto {
    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("文章评论")
    private List<UserComment> comments;
}
