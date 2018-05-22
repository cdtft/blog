package com.cdut.blog.manage.service.es;

import com.cdut.blog.manage.domain.es.Customer;

import java.util.List;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 23:17 2018/5/21
 */
public interface CustomerService {

    /**
     * 更新
     */
    void saveOrUpdate();

    /**
     * find all
     * @return
     */
    List<Customer> findAll();
}
