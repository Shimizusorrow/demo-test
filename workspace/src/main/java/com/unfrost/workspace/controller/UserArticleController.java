package com.unfrost.workspace.controller;

import com.unfrost.workspace.domain.article.UserArticle;
import com.unfrost.workspace.domain.article.UserArticleDomainService;
import com.unfrost.workspace.vo.article.AddUserArticleVO;
import com.unfrost.workspace.vo.article.UpdateUserArticleVO;
import com.unfrost.workspace.repo.article.UserArticleRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-14 08:24
 */
@Api(tags = "文章操作")
@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class UserArticleController {
    private final UserArticleDomainService userArticleDomainService;
    private final UserArticleRepo userArticleRepo;

    @PostMapping("/add")
    @ApiOperation("新增文章")
    public UserArticle add(@RequestBody AddUserArticleVO addUserArticleVO) {
        return userArticleDomainService.add(addUserArticleVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新文章")
    public UserArticle update(@RequestBody UpdateUserArticleVO updateUserArticleDTO) {
        return userArticleDomainService.update(updateUserArticleDTO);
    }

    @DeleteMapping
    @ApiOperation("删除文章")
    public void del(@RequestParam List<String> ids) {
        userArticleDomainService.del(ids);
    }

    @GetMapping
    @ApiOperation("通过Id 查询文章")
    public UserArticle findById(@RequestParam String id) {
        return userArticleRepo.findByIdThrow(id);
    }

    @GetMapping("/list")
    @ApiOperation("列表查询文章")
    public List<UserArticle> findList() {
        return userArticleRepo.findList();
    }

}
