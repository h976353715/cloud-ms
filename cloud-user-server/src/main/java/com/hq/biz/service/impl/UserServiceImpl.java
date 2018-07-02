package com.hq.biz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hq.biz.dao.UserMapper;
import com.hq.biz.model.User;
import com.hq.biz.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Package com.hq.biz.service.impl
 * @Description: UserServiceImpl
 * @date 2018/4/18 10:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



}
