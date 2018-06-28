package com.hq.biz.feign.fallback;

import com.hq.biz.entity.Result;
import com.hq.biz.feign.OAuth2ServerClient;
import org.springframework.stereotype.Component;

/**
 * @author huangqi
 * @Package com.hq.biz.feign.hystrix
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/28 14:19
 */
@Component
public class OAuth2ServerClientHystrix implements OAuth2ServerClient {
    @Override
    public Result removeToken(String token) {
        return Result.returnFail();
    }

}
