package com.unfrost.workspace.domain.article;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.utils.UserUtils;
import com.unfrost.common.base.entity.BaseEntity;
import com.unfrost.workspace.dto.article.AddUserArticleDTO;
import com.unfrost.workspace.dto.article.UpdateUserArticleDTO;
import com.unfrost.workspace.repo.article.UserArticleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-13 11:32
 */
@Service
@AllArgsConstructor
public class UserArticleDomainService {
    private final UserArticleRepo userArticleRepo;

    /**
     * 新增文章
     *
     * @param addUserArticleDTO 文章DTO
     * @return UserArticle
     */
    public UserArticle add(AddUserArticleDTO addUserArticleDTO) {
        User currentUser = UserUtils.gainUserThrow();
        return userArticleRepo.save(new UserArticle(addUserArticleDTO, currentUser));
    }

    /**
     * 修改文章
     *
     * @param updateUserArticleDTO 修改文章DTO
     * @return UserArticle
     */
    public UserArticle update(UpdateUserArticleDTO updateUserArticleDTO) {
        UserArticle find = userArticleRepo.findByIdThrow(updateUserArticleDTO.getId());
        return userArticleRepo.save(new UserArticle(updateUserArticleDTO, find));
    }

    /**
     * 批量删除文章
     *
     * @param ids
     */
    public void del(Collection<String> ids) {
        List<UserArticle> userArticles = ids.stream()
                .map(userArticleRepo::findByIdThrow)
                .peek(BaseEntity::beStopped)
                .collect(Collectors.toList());
        userArticleRepo.saveAll(userArticles);
    }
}
