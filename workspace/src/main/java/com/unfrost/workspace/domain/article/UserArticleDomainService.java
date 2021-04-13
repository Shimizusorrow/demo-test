package com.unfrost.workspace.domain.article;

import com.unfrost.workspace.repo.article.UserArticleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:32
 */
@Service
@AllArgsConstructor
public class UserArticleDomainService {
    private final UserArticleRepo userArticleRepo;
}
