package com.cdut.blog.manage.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

/**
 * @author : wangcheng
 * @description : 自定义身份认证组件，SpringMVC在权限认证时，又AuthenticationManager来管理的
 * 但进行认证的是AuthenticationProvider SpringMVC会去触发authenticate方法。
 * @date : Created in 10:29 2018/3/13
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails loginUser = userDetailsService.loadUserByUsername(username);
        if (Objects.nonNull(loginUser)) {
            //TODO 加密
            if (password.equals(loginUser.getPassword())) {
                return new UsernamePasswordAuthenticationToken(loginUser, password, loginUser.getAuthorities());
            } else {
                throw new BadCredentialsException("密码错误");
            }
        } else {
            throw new UsernameNotFoundException("未找到用户");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
