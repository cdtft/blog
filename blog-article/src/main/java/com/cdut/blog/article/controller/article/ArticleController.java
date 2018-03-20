package com.cdut.blog.article.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdut.blog.article.domain.Article;
import com.cdut.blog.article.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/save")
    public void save(@RequestBody Article article) {
        articleService.save(article);
    }
}
