package com.zisheng;

import com.zisheng.Mapper.TestMapper;
import com.zisheng.Pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WikiApplicationTests {
    @Resource
    private TestMapper testMapper;
    @Test
    public void test_01()
    {
        User user = new User();
        user.setName("张三");
        user.setGender(1);
        user.setAge(21);
        testMapper.insert(user);
    }
}
