package com.hq.biz;

import com.hq.biz.dto.UserDTO;
import com.hq.biz.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huangqi
 * @Package com.hq.biz
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/7/1 22:19
 */
@SpringBootTest
public class Test {


    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        user.setEmail("2131231232@1qdwq");
        String s =null;
        BeanUtils.copyProperties(user,userDTO,s);
        System.out.printf(userDTO.toString());
    }
}
