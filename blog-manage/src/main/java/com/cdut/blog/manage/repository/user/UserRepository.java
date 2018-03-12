package com.cdut.blog.manage.repository.user;

import com.cdut.blog.manage.po.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 17:32 2018/3/12
 */
@Mapper
@Repository
public interface UserRepository {

    User findByUsername(@Param("username") String username);
}
