package com.hq.biz.entity;


import com.hq.biz.base.BaseEntity;

/**
 * @author hq
 * @Package com.hq.entity
 * @Description: 用户类
 * @date 2018/4/12 13:58
 */
public class User extends BaseEntity {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


}
