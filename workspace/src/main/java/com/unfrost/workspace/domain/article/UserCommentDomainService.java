package com.unfrost.workspace.domain.article;

import com.unfrost.workspace.repo.article.UserCommentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:33
 */
@Service
@AllArgsConstructor
public class UserCommentDomainService {
    private final UserCommentRepo userCommentRepo;
}
