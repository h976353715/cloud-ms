package com.hq;

import com.hq.biz.entity.Result;
import com.hq.biz.entity.User;
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
        System.out.printf(new Result<User>("ok","sss",new User()).toString());
    }
}
