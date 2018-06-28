package com.hq.biz.controller;

import com.hq.biz.entity.Result;
import com.hq.biz.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.controller
 * @Description: 返回用户信息
 * @date 2018/4/13 13:58
 */
@RestController
public class UserController {

    @Autowired
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/oauth/remove_token")
    public Result removeToken(@RequestParam("token") String token) {

        if (token != null) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
            tokenStore.removeAccessToken(accessToken);
        } else {
            return new Result(ResultEnum.TOKEN_MISS);
        }

        return Result.returnOk();
    }

}
