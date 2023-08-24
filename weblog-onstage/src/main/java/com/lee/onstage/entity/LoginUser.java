package com.lee.onstage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
public class LoginUser implements UserDetails {
    /**
     * 用户信息
     */
    private User user;
    /**
     * 角色信息
     */
    private List<Role> roleInfo;

    /**
     * 用户权限的集合
     */
    @JsonIgnore
    private List<GrantedAuthority> authorities;

    public List<String> getRoles() {
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
    /**
     * 获取加密后密码
     * @return
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * 用户名
     * @return
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * 是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否被禁用
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *凭证是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    public LoginUser(User user, List<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }
}
