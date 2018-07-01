package com.hq;

import com.hq.biz.entity.Result;
import com.hq.biz.entity.UserDTO;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.printf(new Result<UserDTO>("ok","sss",new UserDTO()).toString());
    }
}
