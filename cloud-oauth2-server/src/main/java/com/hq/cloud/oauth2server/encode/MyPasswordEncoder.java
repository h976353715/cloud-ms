package com.hq.cloud.oauth2server.encode;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server.encode
 * @Description: 明文
 * @date 2018/4/13 17:19
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(arg0.toString());
    }
}
