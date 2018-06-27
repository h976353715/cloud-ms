package com.hq.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Administrator
 * @Package com.hq.gateway.config
 * @Description: GlobalMethodSecurityConfig
 * @date 2018/4/23 15:59
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlobalMethodSecurityConfig  {
}
