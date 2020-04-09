package com.evan;

import com.evan.mapper.database1.UserMapper;
import com.evan.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author evanYang
 * @version 1.0
 * @date 2020/04/09 22:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void demoTest(){
        UserModel userModel = userMapper.selectById(1);
        System.out.println(userModel);

    }
}