package com.cdut.blog.manage.domain.es;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 23:03 2018/5/21
 */
@Document(indexName = "es-search", type = "customer", shards = 2, replicas = 1, refreshInterval = "-1")
@Getter
@Setter
public class Customer {

    @Id
    private String id;

    private String firstname;

    private String lastname;
}
