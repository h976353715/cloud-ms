package com.hq.biz.domain;

import com.hq.biz.base.BaseEntity;

/**
 * @author hq
 * @Package com.hq.entity
 * @Description: 资源类
 * @date 2018/4/12 13:58
 */
public class Permission extends BaseEntity {

    private String id;

    /**
     * 资源编码
     */
    private String perCode;
    /**
     * 资源URL
     */
    private String perPath;
    /**
     * 资源描述
     */
    private String preDesc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    public String getPerPath() {
        return perPath;
    }

    public void setPerPath(String perPath) {
        this.perPath = perPath;
    }

    public String getPreDesc() {
        return preDesc;
    }

    public void setPreDesc(String preDesc) {
        this.preDesc = preDesc;
    }
}
