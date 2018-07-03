package com.hq.biz.base;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Package com.hq.entity
 * @Description: 基础实体类
 * @date 2018/4/12 14:00
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 是否已删除 0：未删除 1：已删除
     */
    protected Integer delFlag;

    protected String createUser;

    protected Date createTime;

    protected String updateUser;

    protected Date updateTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
