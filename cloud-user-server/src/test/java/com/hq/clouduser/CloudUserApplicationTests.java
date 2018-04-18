package com.hq.clouduser;

import com.hq.clouduser.service.UserService;
import com.hq.entity.User;
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
