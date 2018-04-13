package com.hq.cloud.oauth2server.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
