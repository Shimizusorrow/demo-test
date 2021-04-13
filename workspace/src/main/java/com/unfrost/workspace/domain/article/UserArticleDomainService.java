package com.unfrost.workspace.domain.article;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.utils.UserUtils;
import com.unfrost.workspace.dto.AddUserArticleDTO;
import com.unfrost.workspace.dto.UpdateUserArticleDTO;
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

    /**
     * 新增文章
     *
     * @param addUserArticleDTO
     * @return
     */
    public UserArticle add(AddUserArticleDTO addUserArticleDTO) {
        User currentUser = UserUtils.gainUserThrow();
        return userArticleRepo.save(new UserArticle(addUserArticleDTO, currentUser));
    }

    /**
     * 修改文章
     */
    public UserArticle mod(UpdateUserArticleDTO updateUserArticleDTO) {
        UserArticle find = userArticleRepo.findByIdThrow(updateUserArticleDTO.getId());
        return userArticleRepo.save(new UserArticle(updateUserArticleDTO, find));
    }
}
