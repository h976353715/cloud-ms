package com.hq.cloud.oauth2server.handler;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author huangqi
 * @Package com.hq.cloud.oauth2server.handler
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/27 16:21
 */
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {
    public CustomOauthException(String msg) {
        super(msg);
    }
}
