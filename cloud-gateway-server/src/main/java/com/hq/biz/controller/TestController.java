package com.hq.biz.controller;

import com.hq.biz.entity.Result;
import com.hq.biz.feign.UserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Collections;

/**
 * @author Administrator
 * @Package com.hq.biz
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/5/4 10:26
 */
@RestController
public class TestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;
    @Autowired
    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    @Qualifier("userClient")
    private UserClient userClient;

    /**
     * 通过密码授权方式向授权服务器获取令牌
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public Result login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord) throws Exception {
        //Http Basic 验证
        String clientAndSecret = oAuth2ClientProperties.getClientId() + ":" + oAuth2ClientProperties.getClientSecret();
        //这里需要注意为 Basic 而非 Bearer
        clientAndSecret = "Basic " + Base64.getEncoder().encodeToString(clientAndSecret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", clientAndSecret);
        //授权请求信息
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("username", Collections.singletonList(userName));
        map.put("password", Collections.singletonList(passWord));
        map.put("grant_type", Collections.singletonList(oAuth2ProtectedResourceDetails.getGrantType()));
        map.put("scope", oAuth2ProtectedResourceDetails.getScope());
        //HttpEntity
        HttpEntity httpEntity = new HttpEntity(map, httpHeaders);
        //获取 Token
        ResponseEntity<OAuth2AccessToken> exchange = restTemplate.exchange(oAuth2ProtectedResourceDetails.getAccessTokenUri(), HttpMethod.POST, httpEntity, OAuth2AccessToken.class);
        if (HttpStatus.OK.equals(exchange.getStatusCode())) {
            DefaultOAuth2AccessToken body = (DefaultOAuth2AccessToken) exchange.getBody();
            return Result.returnOk(body.getValue());

        } else {
            return Result.returnFail("登录失败！");
        }

    }

    @PreAuthorize("hasAuthority('user:edit')")
    @PostMapping(value = "/hello")
    public Result hello() throws Exception {

        return Result.returnOk("hello");
    }
}
