package com.hq.cloud.oauth2server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.config
 * @Description: 资源服务器（本身也是个资源）
 * @date 2018/4/12 15:41
 */
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /**
         * 自定义权限保护规则
         */
        http
                // 禁用csrf保护
                .csrf().disable()
                // 授权请求
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}
