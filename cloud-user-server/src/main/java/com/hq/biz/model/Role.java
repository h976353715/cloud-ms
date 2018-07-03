package com.hq.biz.model;


import lombok.Data;

/**
 * @author hq
 * @Package com.hq.entity
 * @Description: 角色类
 * @date 2018/4/12 13:58
 */
@Data
public class Role  {

    private String id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色code
     */
    private String roleCode;
    /**
     * 是否可用 1：可用 0:禁用
     */
    private Integer useFlag;



}
