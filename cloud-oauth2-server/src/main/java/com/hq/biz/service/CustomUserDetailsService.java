package com.hq.biz.service;

import com.hq.biz.domain.Permission;
import com.hq.biz.domain.Role;
import com.hq.biz.domain.UserDetail;
import com.hq.biz.dto.UserDTO;
import com.hq.biz.entity.Result;
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
        Result<UserDTO> userDTOResult = userClient.queryByAuth(s);
        return new UserDetail();
    }
}
