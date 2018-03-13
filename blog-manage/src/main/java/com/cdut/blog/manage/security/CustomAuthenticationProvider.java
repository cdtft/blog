package com.cdut.blog.manage.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author : wangcheng
 * @description : 自定义身份认证组件，SpringMVC在权限认证时，又AuthenticationManager来管理的
 * 但进行认证的是AuthenticationProvider SpringMVC会去触发authenticate方法。
 * @date : Created in 10:29 2018/3/13
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
