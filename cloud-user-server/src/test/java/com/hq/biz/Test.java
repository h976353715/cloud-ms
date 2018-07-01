package com.hq.biz;

import com.hq.biz.entity.UserDTO;
import com.hq.biz.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author huangqi
 * @Package com.hq.biz
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/7/1 22:19
 */
@SpringBootTest
public class Test {


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParseException {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        user.setEmail("2131231232@1qdwq");
        user.setCreateTime(new Date());
        String s =null;
        BeanUtils.copyProperties(user,userDTO,s);
        System.out.printf(userDTO.toString());
    }
}
