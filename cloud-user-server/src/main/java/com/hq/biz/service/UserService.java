package com.hq.biz.service;


import com.baomidou.mybatisplus.service.IService;
import com.hq.biz.dto.UserDTO;
import com.hq.biz.model.User;

/**
 * @author Administrator
 * @Package com.hq.biz.service
 * @Description: UserService
 * @date 2018/4/18 10:14
 */
public interface UserService extends IService<User> {

    UserDTO queryByName(String name);

    UserDTO queryByAuth(String name);
}
