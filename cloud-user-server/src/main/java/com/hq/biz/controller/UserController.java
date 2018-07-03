package com.hq.biz.controller;

import com.hq.biz.base.BaseController;
import com.hq.biz.dto.UserDTO;
import com.hq.biz.entity.Result;
import com.hq.biz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Package com.hq.biz.controller
 * @Description: UserController
 * @date 2018/4/18 11:00
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/query")
    public Result<UserDTO> queryByName(@RequestParam("name") String name) {
        UserDTO userDTO = userService.queryByName(name);
        return Result.returnOk(userDTO);
    }

    @PostMapping("/auth")
    public Result<UserDTO> queryByAuth(@RequestParam("name") String name) {
        UserDTO userDTO = userService.queryByAuth(name);
        return Result.returnOk(userDTO);
    }
}
