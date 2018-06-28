package com.hq.biz.service.impl;

import com.hq.biz.dao.UserMapper;
import com.hq.biz.entity.User;
import com.hq.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Package com.hq.clouduser.service.impl
 * @Description: UserServiceImpl
 * @date 2018/4/18 10:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }
}
