package com.unfrost.workspace.repo.article;

import com.unfrost.workspace.domain.article.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:34
 */
public interface UserCommentRepo extends JpaRepository<UserComment,String> {
}
