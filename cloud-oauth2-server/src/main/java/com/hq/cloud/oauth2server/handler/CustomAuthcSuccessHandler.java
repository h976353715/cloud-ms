package com.hq.cloud.oauth2server.handler;

import com.hq.entity.Result;
import com.hq.enums.ResultEnum;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.handler
 * @Description: CustomAuthcSuccessHandler
 * @date 2018/4/20 10:43
 */
@Component
public class CustomAuthcSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE) ||
                request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(new Result<>(ResultEnum.LOGIN_SUCCESS).toString());

        }else{
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
