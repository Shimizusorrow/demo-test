package com.unfrost.workspace.domain.article;

import com.unfrost.admin.domain.User;
import com.unfrost.common.base.entity.BaseEntry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 10:59
 */
@ApiModel(value = "评论")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserComment extends BaseEntry {

    @ApiModelProperty("评论人")
    @ManyToOne
    private User critics;

    @ApiModelProperty("评论内容")
    private String content;

}
