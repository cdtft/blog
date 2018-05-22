package com.cdut.blog.manage.repository.es;

import com.cdut.blog.manage.domain.es.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 23:13 2018/5/21
 */
@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

}
