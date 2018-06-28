package com.hq.biz.config;

import com.hq.biz.handler.CustomAccessDeniedHandler;
import com.hq.biz.handler.CustomAuthEntryPoint;
import com.hq.biz.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author huangqi
 * @Package com.hq.biz.config
 * @Description: ResourceServerConfig
 * @date 2018/6/27 9:39
 */
//@Configuration
//@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    Logger log = LoggerFactory.getLogger(ResourceServerConfig.class);


    @Autowired
    private CustomAuthEntryPoint customAuthEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(customAuthEntryPoint);
    }


}