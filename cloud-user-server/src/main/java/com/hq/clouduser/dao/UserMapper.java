package com.hq.clouduser.dao;

import com.hq.base.BaseMapper;
import com.hq.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hq
 * @Package com.hq.base
 * @Description: BaseMapper
 * @date 2018/4/17 11:08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}