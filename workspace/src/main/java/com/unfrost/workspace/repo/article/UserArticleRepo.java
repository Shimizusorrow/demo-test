package com.unfrost.workspace.repo.article;

import com.unfrost.workspace.domain.article.UserArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:33
 */
public interface UserArticleRepo extends JpaRepository<UserArticle, String> {
}
