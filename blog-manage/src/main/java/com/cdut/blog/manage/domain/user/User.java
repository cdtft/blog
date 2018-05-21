package com.cdut.blog.manage.domain.user;

import com.cdut.myenum.CommonStatusEnum;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Set;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 16:53 2018/3/12
 */
public class User implements UserDetails {

    /**
     *字母加数值
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 启用状态
     */
    private CommonStatusEnum status;

    /**
     * 角色id
     */
    private Set<Long> roleIdSet;

    /**
     * 权限字符串
     */
    private Set<String> authenticationStr;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> grantedAuthoritySet = Sets.newHashSet();

        if (!CollectionUtils.isEmpty(this.authenticationStr)) {
            this.authenticationStr.forEach(str -> {
                grantedAuthoritySet.add(new SimpleGrantedAuthority(str));
            });
        }
        return grantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthenticationStr() {
        return authenticationStr;
    }

    public void setAuthenticationStr(Set<String> authenticationStr) {
        this.authenticationStr = authenticationStr;
    }

    public Set<Long> getRoleIdSet() {
        return roleIdSet;
    }

    public void setRoleIdSet(Set<Long> roleIdSet) {
        this.roleIdSet = roleIdSet;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
}
