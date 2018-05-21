package com.cdut.blog.manage.filter;

import com.cdut.blog.manage.domain.user.User;
import com.cdut.blog.manage.security.BlogTokenAuthenticationService;
import com.cdut.blog.manage.vo.user.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author : wangcheng
 * @description :授权
 * @date : Created in 13:17 2018/3/13
 */
@Component
public class JwtTokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtTokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void setFilterProcessesUrl(String filterProcessesUrl) {
        super.setFilterProcessesUrl(filterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Preconditions.checkArgument(StringUtils.isNotBlank(username));
        Preconditions.checkArgument(StringUtils.isNotBlank(password));
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, Lists.newArrayList()));
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User grantedUser = (User) authResult.getPrincipal();
        Map<String, Object> claims = Maps.newHashMap();
        claims.put(BlogTokenAuthenticationService.KEY_USERNAME, grantedUser.getUsername());
        //TODO 添加角涉信息
        //claims.put(BlogTokenAuthenticationService.KEY_ROLE, )
        String token = BlogTokenAuthenticationService.generateJwtToken(claims);
        response.addHeader(BlogTokenAuthenticationService.HEADER_STRING, token);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
