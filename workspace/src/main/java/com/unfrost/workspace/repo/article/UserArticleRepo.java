package com.unfrost.workspace.repo.article;

import com.unfrost.common.exception.BusinessException;
import com.unfrost.workspace.domain.article.UserArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:33
 */
public interface UserArticleRepo extends JpaRepository<UserArticle, String> {
    /**
     * 通过Id 查询文章
     *
     * @param id
     * @return
     */
    default UserArticle findByIdThrow(String id) {
        return findById(id).orElseThrow(() -> new BusinessException("文章不存在!"));
    }

    /**
     * 查询未被删除的文章
     *
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from user_article ua where ua.life_state = 'RUNNING' order by ua.update_time ")
    List<UserArticle> findList();
}
