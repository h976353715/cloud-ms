package com.hq.biz.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hq.biz.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2018-07-03
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    /**
     * 获取资源权限信息
     *
     * @param name
     * @return
     */
    List<Permission> getPerByName(@Param("userName") String name);
}
