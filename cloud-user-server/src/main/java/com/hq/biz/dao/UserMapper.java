package com.hq.biz.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hq.biz.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author hq
 * @Package com.hq.biz.dao
 * @Description: BaseMapper
 * @date 2018/4/17 11:08
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}