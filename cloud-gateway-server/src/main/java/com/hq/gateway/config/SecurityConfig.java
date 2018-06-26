package com.hq.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.Filter;

/**
 * @author Administrator
 * @Package com.hq.gateway.config
 * @Description: SecurityConfig
 * @date 2018/4/23 15:59
 */
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Filter ssoFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(ssoFilter, BasicAuthenticationFilter.class)
                .antMatchers("/demo", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();
    }

}
