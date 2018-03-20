package com.cdut.blog.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdut.blog.article.domain.Article;
import com.cdut.blog.article.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public void save(Article article) {
        repository.save(article);
    }
}
