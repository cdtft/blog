package com.cdut.jpa.base;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

/**
 * @author : wangcheng
 * @date : 2018/3/6
 */
public class CommonRepositoryFactory extends JpaRepositoryFactory {

    public CommonRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return CommonJpaRepositoryBean.class;
    }
}
