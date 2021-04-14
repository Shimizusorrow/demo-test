package com.unfrost.workspace.vo.article;

import com.unfrost.common.vo.BaseUpdateVO;
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
public class UpdateUserArticleVO extends BaseUpdateVO {
    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("文章评论")
    private List<UserComment> comments;
}
