package com.hq.biz.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @author huangqi
 * @Package com.hq.cloud.oauth2server.handler
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/27 16:31
 */
@Component("customWebResponseExceptionTranslator")
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<Exception> translate(Exception e) throws Exception {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new CustomOauthException(e.getMessage()));
    }
}
