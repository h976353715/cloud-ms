package com.hq.biz.service;

import com.hq.biz.domain.CustUserDetails;
import com.hq.biz.dto.UserDTO;
import com.hq.biz.entity.Result;
import com.hq.biz.feign.UserClient;
import com.hq.biz.utils.ObjectConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
    public UserDetails loadUserByUsername(String name) {
        Result<UserDTO> userDTOResult = userClient.queryByAuth(name);
        if (userDTOResult.getRespData() != null) {
            UserDTO respData = userDTOResult.getRespData();
            CustUserDetails userDetails = ObjectConvertUtil.convert(respData, CustUserDetails.class);
            return userDetails;
        } else {
            throw new UsernameNotFoundException(name);
        }
    }
}
