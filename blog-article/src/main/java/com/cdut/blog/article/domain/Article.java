package com.cdut.blog.article.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "cdut_blog_article")
@Data
public class Article {

    @Id
    private String id;

    private String content;
}
