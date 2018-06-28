package com.hq.biz.enums;

/**
 * @author hq
 * @Package com.hq.enums
 * @Description: 返回编码枚举类
 * @date 2018/4/17 10:36
 */
public enum ResultEnum {
    SUCCESS("0000", "成功"),
    FAIL("0001", "失败"),
    SERVER_ERROR("0003", "系统服务异常"),
    LOGIN_SESSION_MISS("0004", "会话失效"),
    LOGIN_SUCCESS("0005", "登录成功"),
    LOGIN_FAIL("0006", "登录失败"),
    LOGIN_USER_ERR("0007", "用户名或密码错误"),
    LOGOUT_FAIL("0008", "注销失败"),
    TOKEN_MISS("0009","令牌缺失");


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
