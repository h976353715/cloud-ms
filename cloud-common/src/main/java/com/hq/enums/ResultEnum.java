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
    FAIL("10", "失败");

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
