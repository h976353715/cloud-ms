package com.hq.biz.enums;

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
    SUCCESS("0000", "成功"),

    /**
     * 失败
     */
    FAIL("0001", "失败"),

    SERVER_ERROR("0003", "系统服务异常"),

    /**
     * 登录成功
     */
    LOGIN_SUCCESS("200", "登录成功"),
    /**
     * 登录失败
     */
    LOGIN_FAIL("500", "登录失败");


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
