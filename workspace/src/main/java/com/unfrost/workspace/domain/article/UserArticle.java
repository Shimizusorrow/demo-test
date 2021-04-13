package com.unfrost.workspace.domain.article;

import com.unfrost.admin.domain.User;
import com.unfrost.common.base.entity.BaseEntity;
import com.unfrost.common.constant.BaseEntityConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shimizu
 * @description 创作文章
 * @date 2021-04-12 13:16
 */
@ApiModel(value = "文章")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserArticle extends BaseEntity {
    @ApiModelProperty("文章撰写人")
    @ManyToOne
    private User author;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content = "";

    @ApiModelProperty("文章评论")
    @OneToMany
    @OrderBy(BaseEntityConstants.CREATE_TIME)
    @JoinColumn(name = UserComment.PARENT_ID,
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT),
            referencedColumnName = "id")
    private List<UserComment> comments;

    public UserArticle(User author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
