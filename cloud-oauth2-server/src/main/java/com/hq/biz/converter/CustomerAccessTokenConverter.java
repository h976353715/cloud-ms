package com.hq.biz.converter;

import com.hq.biz.domain.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 97874
 * @Package com.hq.cloud.oauth2server.converter
 * @Description: 自定义jwt内容
 * @date 2018/4/15 12:51
 */
public class CustomerAccessTokenConverter extends DefaultAccessTokenConverter {


    public CustomerAccessTokenConverter() {
        super.setUserTokenConverter(new CustomerUserAuthenticationConverter());
    }

    private class CustomerUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

        @Override
        public Map<String, ?> convertUserAuthentication(Authentication authentication) {
            LinkedHashMap response = new LinkedHashMap();
            response.put("user_name", authentication.getName());
            response.put("phone", ((UserDetail) authentication.getPrincipal()).getPhone());
            if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
                response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
            }

            return response;
        }
    }

}
