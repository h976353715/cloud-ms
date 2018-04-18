package com.hq.clouduser.controller;

import com.hq.base.BaseController;
import com.hq.clouduser.service.UserService;
import com.hq.entity.Result;
import com.hq.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Package com.hq.clouduser.controller
 * @Description: UserController
 * @date 2018/4/18 11:00
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger log =LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user/{id}")
    public Result<User> query(@PathVariable("id")String id){
        User user = userService.selectByPrimaryKey(id);
        return Result.returnOk(user);
    }

    @PostMapping("/authUser/{id}")
    public User queryByAuth(@PathVariable("id")String id){
        User user = userService.selectByPrimaryKey(id);
        return user;
    }
}
