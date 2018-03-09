package com.cdut.blog.manage.repository.cat;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 18:02 2018/3/8
 */
@Mapper
public interface CatMapper {

    void delete(@Param("id") Long id);
}
