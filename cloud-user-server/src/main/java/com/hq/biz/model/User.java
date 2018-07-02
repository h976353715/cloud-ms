package com.hq.biz.model;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.hq.biz.base.BaseEntity;
import lombok.Data;

/**
 * @author hq
 * @Package com.hq.entity
 * @Description: 用户类
 * @date 2018/4/12 13:58
 */
@Data
@TableName("t_user")
public class User extends BaseEntity{

    @TableId
    private String id;
    /**
     * 用户名
     */
    @TableField("username")
    private String userName;
    /**
     * 密码
     */
    @TableField("password")
    private String passWord;
    /**
     * 电话
     */
    @TableField("phone")
    private String phone;
    /**
     * 邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }
}
