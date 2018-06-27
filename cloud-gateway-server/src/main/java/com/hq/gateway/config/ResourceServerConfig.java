package com.hq.gateway.config;

import com.hq.gateway.handler.CustomAccessDeniedHandler;
import com.hq.gateway.handler.CustomAuthEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @author huangqi
 * @Package com.hq.gateway.config
 * @Description: ResourceServerConfig
 * @date 2018/6/27 9:39
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    Logger log = LoggerFactory.getLogger(ResourceServerConfig.class);


    @Autowired(required = false)
    private RemoteTokenServices remoteTokenServices;

    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Autowired
    private AuthorizationServerProperties authorizationServerProperties;

    @Autowired
    private CustomAuthEntryPoint customAuthEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public AuthorizationServerProperties authorizationServerProperties() {
        return new AuthorizationServerProperties();
    }


    @Bean
    @Qualifier("authorizationHeaderRequestMatcher")
    public RequestMatcher authorizationHeaderRequestMatcher() {
        return new RequestHeaderRequestMatcher("Authorization");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .exceptionHandling().authenticationEntryPoint(customAuthEntryPoint)
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestMatcher(authorizationHeaderRequestMatcher())
                .authorizeRequests()
                .antMatchers("/login").permitAll();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices())
                .accessDeniedHandler(customAccessDeniedHandler)
                .authenticationEntryPoint(customAuthEntryPoint);

    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("hq-jwt.cert");
        String publicKey;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }


    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
        remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
        remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
        return remoteTokenServices;
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }


}
