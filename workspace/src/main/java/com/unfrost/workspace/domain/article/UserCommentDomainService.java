package com.unfrost.workspace.domain.article;

import com.unfrost.admin.utils.UserUtils;
import com.unfrost.workspace.vo.article.AddUserCommentVO;
import com.unfrost.workspace.repo.article.UserArticleRepo;
import com.unfrost.workspace.repo.article.UserCommentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:33
 */
@Service
@AllArgsConstructor
public class UserCommentDomainService {
    private final UserCommentRepo userCommentRepo;
    private final UserArticleRepo userArticleRepo;

    /**
     * 新增评论
     *
     * @param addUserCommentVO
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(AddUserCommentVO addUserCommentVO) {
        UserArticle article = userArticleRepo.findByIdThrow(addUserCommentVO.getArticleId());
        article.addComment(new UserComment(UserUtils.gainUserThrow(), addUserCommentVO.getContent()));
        userArticleRepo.save(article);
    }

    /**
     * 删除评论
     *
     * @param id 评论Id
     */
    public void del(String id) {
        UserComment find = userCommentRepo.findByIdThrow(id);
        find.beStopped();
        userCommentRepo.save(find);
    }

    /**
     * 查询文章评论
     *
     * @param id 文章Id
     * @return
     */
    public List<UserComment> findByArticleId(String id) {
        return userCommentRepo.findByArticleId(id);
    }

    /**
     * 查询 评论者的所有评论
     *
     * @param id 评论人Id
     * @return
     */
    public List<UserComment> findByCriticId(String id) {
        return userCommentRepo.findByCriticId(id);
    }
}
