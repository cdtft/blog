package com.cdut.blog.manage.service.user;

import com.cdut.blog.manage.po.user.User;
import com.cdut.blog.manage.repository.user.UserRepository;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 17:20 2018/3/12
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 登陆验证
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("用户名为空！");
        }

        User loginUser = userRepository.findByUsername(username);
        if (Objects.isNull(loginUser)) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        return loginUser;
    }
}
