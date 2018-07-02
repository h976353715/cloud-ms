package com.hq.biz.controller;

import com.hq.biz.dto.UserDTO;
import com.hq.biz.entity.Result;
import com.hq.biz.enums.ResultEnum;
import com.hq.biz.feign.OAuth2ServerClient;
import com.hq.biz.feign.UserClient;
import com.hq.biz.utils.BCryptUtil;
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
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Package com.hq.biz
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/5/4 10:26
 */
@RestController
@RequestMapping("/hq")
public class LoginController {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;
    @Autowired
    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    @Autowired
    private OAuth2ServerClient oAuth2ServerClient;

    @Autowired
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    /**
     * 通过密码授权方式向授权服务器获取令牌
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public Result login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord) throws Exception {
        //验证用户名密码
        Result<UserDTO> userDTOResult = userClient.queryByName(userName);
        if (!ResultEnum.SUCCESS.getCode().equals(userDTOResult.getRespCode())) {
            return Result.returnFail(ResultEnum.LOGIN_FAIL);
        }
        UserDTO respData = userDTOResult.getRespData();
        if(BCryptUtil.isMatch(passWord,respData.getPassWord())){
            ResponseEntity<OAuth2AccessToken> responseEntity = getToken(userName, passWord);
            if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
                DefaultOAuth2AccessToken body = (DefaultOAuth2AccessToken) responseEntity.getBody();
                Map<String, String> tkMap = new HashMap<>();
                tkMap.put("access_token", body.getValue());
                tkMap.put("refresh_token", body.getRefreshToken().getValue());
                return Result.returnOk(tkMap);
            } else {
                return Result.returnFail(ResultEnum.LOGIN_FAIL);
            }
        }else {
            return Result.returnFail(ResultEnum.LOGIN_USER_ERR);
        }
    }

    @RequestMapping("/logout")
    public Result exit(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String tokenValue = authHeader.replace("bearer", "").trim();
        Result result = oAuth2ServerClient.removeToken(tokenValue);
        if (!ResultEnum.SUCCESS.getCode().equals(result.getRespCode())) {
            return new Result(ResultEnum.LOGOUT_FAIL);
        }

        return new Result(ResultEnum.SUCCESS.getCode(), "注销成功");
    }

    @PreAuthorize("hasAuthority('user:edit')")
    @PostMapping(value = "/hello")
    public Result hello() throws Exception {

        return Result.returnOk("hello");
    }

    public ResponseEntity<OAuth2AccessToken> getToken(String userName, String passWord) {
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
        return exchange;
    }

}
