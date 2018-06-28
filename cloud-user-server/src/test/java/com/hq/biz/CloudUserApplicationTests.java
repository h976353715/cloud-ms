package com.hq.biz;

import com.hq.biz.entity.User;
import com.hq.biz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudUserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = userService.selectByPrimaryKey("1");
        System.out.printf(user.toString());
    }

}
