package com.unfrost.workspace.repo.article;

import com.unfrost.common.exception.BusinessException;
import com.unfrost.workspace.domain.article.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:34
 */
public interface UserCommentRepo extends JpaRepository<UserComment, String> {
    /**
     * 通过Id 查询评论
     *
     * @param id
     * @return
     */
    default UserComment findByIdThrow(String id) {
        return findById(id).orElseThrow(() -> new BusinessException("评论不存在!"));
    }

    /**
     * 查询文章的评论
     *
     * @param id
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from user_comment uc where uc.parent_id = :id and uc.life_state ='RUNNING' order by uc.create_time")
    List<UserComment> findByArticleId(String id);

    /**
     * 查询评论者的所有评论
     *
     * @param id
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from user_comment uc where uc.critics_id = :id and uc.life_state='RUNNING' order by uc.create_time")
    List<UserComment> findByCriticId(String id);
}
