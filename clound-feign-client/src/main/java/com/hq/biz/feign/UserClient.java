package com.hq.biz.feign;

import com.hq.biz.dto.UserDTO;
import com.hq.biz.feign.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.feign
 * @Description: UserClient
 * @date 2018/4/18 11:05
 */
@FeignClient(value = "cloud-user",fallback = UserClientFallBack.class)
public interface UserClient {

    @PostMapping("/user/authUser/{id}")
    UserDTO queryByAuth(@PathVariable("id") String id);
}
