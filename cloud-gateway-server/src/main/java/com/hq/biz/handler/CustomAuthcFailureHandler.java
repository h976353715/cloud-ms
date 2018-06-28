package com.hq.biz.handler;

import com.hq.biz.entity.Result;
import com.hq.biz.enums.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.handler
 * @Description: CustomAuthcFailureHandler
 * @date 2018/4/20 10:37
 */
@Component
public class CustomAuthcFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //直接返回JSON字符串
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().print(new Result<>(ResultEnum.LOGIN_FAIL).toString());
    }
}
