package com.hq.biz.service;

import com.hq.biz.domain.Permission;
import com.hq.biz.domain.Role;
import com.hq.biz.domain.UserDetail;
import com.hq.biz.feign.UserClient;
import com.hq.biz.utils.BCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server
 * @Description: 自定义用户信息
 * @date 2018/4/12 15:35
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserClient userClient;
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetail userDetail = new UserDetail();
        if ("huang".equals(s)) {
            Permission permission = new Permission();
            permission.setPerCode("user:edit");
            List<Permission> plist = new ArrayList<>();
            plist.add(permission);

            Role role = new Role();
            role.setRoleCode("admin");
            role.setPermissions(plist);

            List<Role> roleList = new ArrayList<>();
            roleList.add(role);
            userDetail.setRoles(roleList);
            userDetail.setUserName(s);
            userDetail.setPassWord(BCryptUtil.encode("123456"));
        } else {
            throw new UsernameNotFoundException(s);
        }

        return userDetail;
    }
}
