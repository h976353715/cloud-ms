package com.hq.biz.feign;

import com.hq.biz.entity.Result;
import com.hq.biz.feign.fallback.OAuth2ServerClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangqi
 * @Package com.hq.biz.feign
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/28 14:17
 */
@FeignClient(value = "cloud-oauth2", fallback = OAuth2ServerClientHystrix.class)
public interface OAuth2ServerClient {
    @RequestMapping(value = "/oauth/remove_token",method = RequestMethod.POST)
    Result removeToken(@RequestParam("token") String token);
}
