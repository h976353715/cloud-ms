package com.hq.cloud.oauth2server.controller;

import com.hq.entity.Result;
import com.hq.enums.ResultEnum;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping({"/oauth2/error"})
    public Result handleError(HttpServletRequest request) {
        Map<String, Object> model = new HashMap();
        Object error = request.getAttribute("error");
        String errorSummary;
        if (error instanceof OAuth2Exception) {
            OAuth2Exception oauthError = (OAuth2Exception)error;
            errorSummary = HtmlUtils.htmlEscape(oauthError.getSummary());
        } else {
            errorSummary = "Unknown error";
        }
        Result result = new Result(ResultEnum.NOAUTHENTICATE);
        model.put("errorSummary", errorSummary);
        return result;
    }
}
