package com.hq.biz.model;


import com.hq.biz.base.BaseEntity;
import lombok.Data;

/**
 * @author hq
 * @Package com.hq.entity
 * @Description: 资源类
 * @date 2018/4/12 13:58
 */
@Data
public class Permission {

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

}
