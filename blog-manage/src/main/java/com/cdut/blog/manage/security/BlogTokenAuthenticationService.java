package com.cdut.blog.manage.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 11:16 2018/3/10
 */
public class BlogTokenAuthenticationService {

    private static final long EXPIRATION_TIME = 864_000_00;

    private static final String SECURITY = "cdut_blog";

    private static final String HEADER_STRING = "Authorization";

    /**
     * 授权
     * @param response resp
     * @param username 用户名
     */
    public static void addAuthentication(HttpServletResponse response, String username) {
        String jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECURITY)
                .compact();
        response.addHeader(HEADER_STRING, jwt);
    }

}
