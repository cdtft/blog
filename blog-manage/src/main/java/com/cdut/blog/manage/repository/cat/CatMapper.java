package com.cdut.blog.manage.repository.cat;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 18:02 2018/3/8
 */
@Mapper
@Repository
public interface CatMapper {

    void delete(@Param("id") Long id);
}
