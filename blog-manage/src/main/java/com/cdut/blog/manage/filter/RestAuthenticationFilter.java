package com.cdut.blog.manage.filter;

import com.cdut.blog.manage.security.BlogTokenAuthenticationService;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author : wangcheng
 * @description : 鉴权
 * @date : Created in 17:11 2018/3/13
 */
@Component
public class RestAuthenticationFilter extends BasicAuthenticationFilter {

    private static final String QUERY_FIELD = "username";

    @Autowired
    @Qualifier("userService")
    private UserDetailsService userDetailsService;

    public RestAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(BlogTokenAuthenticationService.HEADER_STRING);
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        Claims claims = BlogTokenAuthenticationService.parseUserDetailFormToken(token);
        if (Objects.nonNull(claims)) {
            UserDetails loginUser = userDetailsService.loadUserByUsername((String) claims.get(QUERY_FIELD));
            if  (Objects.nonNull(loginUser)) {
                return new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            }
        }
        return null;
    }
}
