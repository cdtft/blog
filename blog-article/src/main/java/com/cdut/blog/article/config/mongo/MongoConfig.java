package com.cdut.blog.article.config.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * MongoDB 相关数据值.
 * 
 * @author : Zilean
 * @date : 2018-03-12 13:03
 */
@Component
@Data
public class MongoConfig {

    @Value("${spring.data.mongodb.first.host}")
    private String firstHost;

    @Value("${spring.data.mongodb.second.host}")
    private String secondHost;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.cdut.database}")
    private String cdutDatabase;

    @Value("${spring.data.mongodb.cdut.username}")
    private String cdutUsername;

    @Value("${spring.data.mongodb.cdut.password}")
    private String cdutPassword;

    @Value("${spring.data.mongodb.timeout}")
    private int timeout;
}
