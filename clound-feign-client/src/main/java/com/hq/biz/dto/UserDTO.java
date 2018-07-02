package com.hq.biz.dto;


import com.hq.biz.base.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @author hq
 * @Package com.hq.biz.dto
 * @Description: 用户类
 * @date 2018/4/12 13:58
 */
@Data
public class UserDTO extends BaseEntity {

    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private Integer sex;

    /**
     * 资源集合
     */
    List<PermissionDTO> permissionList;

    /**
     * 权限集合
     */
    List<RoleDTO> roleList;


}
