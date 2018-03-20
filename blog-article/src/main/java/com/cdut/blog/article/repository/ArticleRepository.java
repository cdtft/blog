package com.cdut.blog.article.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.cdut.blog.article.domain.Article;
import com.cdut.blog.search.mongodb.base.CommonMongoOperation;

@Component
public class ArticleRepository {

    @Autowired
    private MongoTemplate template;

    public void save(Article article) {
        CommonMongoOperation.save(template, article);
    }
}
