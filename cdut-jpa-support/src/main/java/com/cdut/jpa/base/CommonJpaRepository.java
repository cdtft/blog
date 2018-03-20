package com.cdut.jpa.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author : wangcheng
 * @date : 2018/3/6
 */
@NoRepositoryBean
public interface CommonJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {


    void persist(T entity);

}

