package com.hq.base;

import com.hq.constant.Constant;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Package com.hq.entity
 * @Description: 基础实体类
 * @date 2018/4/12 14:00
 */
public class BaseEntity implements Serializable {

    /**
     * 是否已删除 0：未删除 1：已删除
     */
    protected Integer delFlag;

    protected String createUser;

    protected Date createTime;

    protected String updateUser;

    protected Date updateTime;

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        if (delFlag == null) {
            delFlag = Constant.UNDELETED;
        }
        this.delFlag = delFlag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
