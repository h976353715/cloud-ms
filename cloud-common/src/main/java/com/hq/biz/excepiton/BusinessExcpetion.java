package com.hq.biz.excepiton;

import com.hq.biz.enums.ResultEnum;

/**
 * @author huangqi
 * @Package com.hq.biz.excepiton
 * @Description: 自定义业务异常
 * @date 2018/7/3 16:09
 */
public class BusinessExcpetion extends RuntimeException {
    static final long serialVersionUID = 1L;
    private String code;

    public BusinessExcpetion(String message) {
        super(message);
        this.code = ResultEnum.FAIL.getCode();
    }

    public BusinessExcpetion(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessExcpetion(ResultEnum statusEnum) {
        super(statusEnum.getDesc());
        this.code = statusEnum.getCode();
    }

    public BusinessExcpetion(String code, String message, Object... args) {
        super(String.format(message, args));
        this.code = code;
    }

    public BusinessExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
