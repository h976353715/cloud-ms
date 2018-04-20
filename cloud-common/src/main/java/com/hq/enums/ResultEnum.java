package com.hq.enums;

/**
 * @author hq
 * @Package com.hq.enums
 * @Description: 返回编码枚举类
 * @date 2018/4/17 10:36
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS("00", "成功"),

    /**
     * 失败
     */
    FAIL("10", "失败"),
    /**
     * 未登录返回
     */
    NOAUTHENTICATE("401","token或无效"),
    /**
     * 无权限返回
     */
    NOAUTHENTIZATE("403","无权限"),
    /**
     * 登录成功
     */
    LOGIN_SUCCESS("200","登录成功"),
    /**
     * 登录失败
     */
    LOGIN_FAIL("500","登录失败");


    ResultEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
