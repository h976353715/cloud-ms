package com.hq.gateway.feign.hystrix;

import com.hq.entity.User;
import com.hq.gateway.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.feign.fallback
 * @Description: UserClientFallBack
 * @date 2018/4/18 11:33
 */
@Component(value = "userClient")
public class UserClientFallBack implements UserClient {

    @Override
    public User queryByAuth(String id) {
        return new User();
    }
}
