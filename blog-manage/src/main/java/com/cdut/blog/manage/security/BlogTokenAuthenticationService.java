package com.cdut.blog.manage.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 11:16 2018/3/10
 */
public class BlogTokenAuthenticationService {

    private static final long EXPIRATION_TIME = 864_000_00;

    private static final String SECURITY = "cdut_blog";

    public static final String HEADER_STRING = "Authorization";

    public static final String KEY_USERNAME = "username";

    public static final String KEY_ROLE = "role";

    /**
     * @param detail 详细信息map
     * @return
     */
    public static String generateJwtToken(Map<String,Object> detail) {
        return Jwts.builder()
                .setClaims(detail)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECURITY)
                .compact();
    }

    public static Claims parseUserDetailFormToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECURITY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {

            return null;
        }
        return claims;
    }



}
