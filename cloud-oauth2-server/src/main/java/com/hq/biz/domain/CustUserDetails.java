package com.hq.biz.domain;

import com.hq.biz.dto.PermissionDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.domain
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/4/13 11:28
 */
@Data
public class CustUserDetails implements UserDetails {

    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private Integer sex;

    /**
     * 角色合集
     */
    private List<Role> roles;
    /**
     * 角色合集
     */
    private List<PermissionDTO> permissions;

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (PermissionDTO per : permissions) {
            authorities.add(new SimpleGrantedAuthority(per.getPerCode()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
