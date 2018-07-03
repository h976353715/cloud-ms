package com.hq.biz.feign.fallback;

import com.hq.biz.dto.UserDTO;
import com.hq.biz.entity.Result;
import com.hq.biz.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.feign.fallback
 * @Description: UserClientFallBack
 * @date 2018/4/18 11:33
 */
@Component
public class UserClientFallBack implements UserClient {

    @Override
    public Result<UserDTO> queryByName(String name) {
        return Result.returnFail();
    }

    @Override
    public Result<UserDTO> queryByAuth(String name) {
        return Result.returnFail();
    }
}
