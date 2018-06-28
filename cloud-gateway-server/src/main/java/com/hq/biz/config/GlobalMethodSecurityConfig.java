package com.hq.biz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Administrator
 * @Package com.hq.biz.config
 * @Description: GlobalMethodSecurityConfig
 * @date 2018/4/23 15:59
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlobalMethodSecurityConfig  {
}
