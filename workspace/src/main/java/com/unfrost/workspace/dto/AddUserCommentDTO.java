package com.unfrost.workspace.dto;

import lombok.Data;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 09:53
 */
@Data
public class AddUserCommentDTO {
    /**
     * 文章Id
     */
    private String articleId;

    /**
     * 评论内容
     */
    private String content;
}
