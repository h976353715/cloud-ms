package com.hq.cloud.oauth2server.service;

import com.hq.cloud.oauth2server.domain.CustomUserDetail;
import com.hq.cloud.oauth2server.domain.Permission;
import com.hq.cloud.oauth2server.domain.Role;
import com.hq.cloud.oauth2server.util.BCryptUtil;
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
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomUserDetail user = new CustomUserDetail();
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
            user.setRoles(roleList);
            user.setUserName(s);
            user.setPassWord(BCryptUtil.encode("123456"));
        } else {
            throw new UsernameNotFoundException(s);
        }

        return user;
    }
}
