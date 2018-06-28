package com.hq.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Administrator
 * @Package com.hq.cloud.oauth2server
 * @Description: 加密工具
 * @date 2018/4/13 16:42
 */
public class BCryptUtil {

    public static String encode(String str) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(str);
    }

    public static boolean isMatch(String passWord, String encodePassWord) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(passWord, encodePassWord);
    }
    /*public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode=bCryptPasswordEncoder.encode("hq");
        String encode1=bCryptPasswordEncoder.encode("hq");
        System.out.println(encode);
        System.out.println("bcrypt密码对比1:" + bCryptPasswordEncoder.matches("hq", encode));
        System.out.println("bcrypt密码对比2:" + bCryptPasswordEncoder.matches("hq", encode1));

    }*/
}
