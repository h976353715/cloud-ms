package com.hq.cloud.oauth2server.config;

import com.hq.cloud.oauth2server.handler.CustomAccessDeniedHandler;
import com.hq.cloud.oauth2server.handler.CustomAuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.config
 * @Description: 资源服务器（本身也是个资源）
 * @date 2018/4/12 15:41
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 注册 401 处理器
     */
    @Autowired
    private CustomAuthEntryPoint customAuthEntryPoint;

    /**
     * 注册 403 处理器
     */
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("oauth").stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // 授权请求
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                ;

    }
}
