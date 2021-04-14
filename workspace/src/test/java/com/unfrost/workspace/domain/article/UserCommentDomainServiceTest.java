package com.unfrost.workspace.domain.article;

import com.unfrost.admin.domain.User;
import com.unfrost.admin.enums.GenderEnum;
import com.unfrost.admin.enums.RoleEnum;
import com.unfrost.workspace.repo.article.UserCommentRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles(value = "junit")
@EntityScan(basePackages = {"com.unfrost.admin",
        "com.unfrost.workspace"})
class UserCommentDomainServiceTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserCommentRepo userCommentRepo;

    @Test
    void notNull() {
        assertNotNull(entityManager);
        assertNotNull(userCommentRepo);
    }

    @BeforeEach
    void data() {
        String title = "Hello world";
        String content = "你好啊,世界!";
        User admin = new User("admin", "1", RoleEnum.SUPER_ADMIN, GenderEnum.MALE, "");
        admin.setId("1");
        admin = entityManager.merge(admin);
        UserArticle article = new UserArticle(admin, title, content);
        article.setId("1");
        UserArticle merge = entityManager.merge(article);
        System.out.println(merge.getId());
    }

    /**
     * 新增评论
     */
    @Test
    void add() {
        UserArticle article = entityManager.find(UserArticle.class, "1");
        assertNotNull(article);
        User user = entityManager.find(User.class, "1");
        UserComment comment = new UserComment(user, "一起努力!");
//        comment = entityManager.merge(comment);
        article.addComment(comment);
        UserArticle save = entityManager.merge(article);

        assertEquals(1, save.getComments().size(), "评论数量不正确");
        assertEquals("一起努力!", save.getComments().get(0).getContent(), "评论内容不正确");
        assertEquals(user.getName(), save.getComments().get(0).getCritics().getName(), "用户不正确");
    }
}