package com.unfrost.workspace.domain.article;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.enums.GenderEnum;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.workspace.repo.article.UserArticleRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles(value = "junit")
@EntityScan(basePackages = {"com.unfrost.admin",
        "com.unfrost.workspace"})
class UserArticleDomainServiceTest {
    @InjectMocks
    private UserArticleDomainService userArticleDomainService;
    @Autowired
    private UserArticleRepo userArticleRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void notNull() {
        assertNotNull(userArticleRepo);
        assertNotNull(userArticleDomainService);
        assertNotNull(entityManager);
    }

    @Test
    void addUserArticle() {
        String title = "Hello world";
        String content = "你好啊,世界!";
        User admin = new User("admin", "1", RoleEnum.SUPER_ADMIN, GenderEnum.MALE, "");
        admin = entityManager.merge(admin);
        UserArticle article = new UserArticle(admin, title, content);
        UserArticle save = userArticleRepo.save(article);
        assertEquals(title, save.getTitle(), String.format("标题不符合%s", title));
        assertEquals(content, save.getContent(), String.format("内容不符合%s", title));
        assertEquals(admin.getName(), save.getAuthor().getName(), String.format("用户不符合%s", admin));
    }
}