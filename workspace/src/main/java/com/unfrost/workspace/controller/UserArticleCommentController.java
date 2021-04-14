package com.unfrost.workspace.controller;

import com.unfrost.workspace.domain.article.UserComment;
import com.unfrost.workspace.domain.article.UserCommentDomainService;
import com.unfrost.workspace.dto.article.AddUserCommentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 10:06
 */
@Api(tags = "文章评论")
@RestController
@RequestMapping("/article-comment")
@AllArgsConstructor
public class UserArticleCommentController {
    private final UserCommentDomainService userCommentDomainService;

    @PostMapping
    @ApiOperation("对某一文章添加评论")
    public void add(@RequestBody AddUserCommentDTO addUserCommentDTO) {
        userCommentDomainService.add(addUserCommentDTO);
    }

    @DeleteMapping
    @ApiOperation("删除某一文章评论")
    public void del(@RequestParam String id) {
        userCommentDomainService.del(id);
    }

    @GetMapping("/article-id")
    @ApiOperation("查询某一文章评论")
    public List<UserComment> findArticleId(@RequestParam String id) {
        return userCommentDomainService.findByArticleId(id);
    }

    @GetMapping("user-id")
    @ApiOperation("查询某一评论者的所有评论")
    public List<UserComment> findByCriticId(@RequestParam String id) {
        return userCommentDomainService.findByCriticId(id);
    }
}
