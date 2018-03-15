package com.cdut.blog;

import com.cdut.blog.search.mongodb.base.CommonMongoOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cdut.blog.article.BlogArticleApplication;
import com.cdut.blog.article.domain.Article;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogArticleApplication.class)
@ActiveProfiles(value = "dev")
@Log4j2
public class TestMongoDb {

    @Autowired
    private MongoTemplate template;

    @Test
    public void mongoDb() {
        log.info("mongoDb begin!");
        Article article = new Article();
        article.setContent("hello world!");
        CommonMongoOperation.save(template, article);
        // CommonMongoOperation.delete(template, article);
    }
}
