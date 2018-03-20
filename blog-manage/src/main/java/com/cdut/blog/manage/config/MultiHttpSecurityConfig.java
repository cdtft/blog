package com.cdut.blog.manage.config;

import com.cdut.blog.manage.filter.JwtTokenAuthenticationFilter;
import com.cdut.blog.manage.filter.RestAuthenticationFilter;
import com.cdut.blog.manage.security.CustomAuthenticationProvider;
import com.cdut.blog.manage.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 11:06 2018/3/10
 */
@EnableWebSecurity
public class MultiHttpSecurityConfig {

    /**
     * rest 接口权限验证
     */
    @Configuration
    @Order(1)
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier("userService")
        private UserDetailsService userDetailsService;

        @Autowired
        private RestAuthenticationFilter restAuthenticationFilter;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService));
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/api/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .addFilter(restAuthenticationFilter)
                    .addFilterBefore(jwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .httpBasic();
        }

        @Bean
        public JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter() throws Exception {
            JwtTokenAuthenticationFilter filter = new JwtTokenAuthenticationFilter(super.authenticationManager());
            filter.setFilterProcessesUrl("/api/login");
            return filter;
        }

    }

    /**
     * 后台管理系统接口验证
     */
    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier("userService")
        private UserDetailsService userDetailsService;

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin();
        }
    }
}
