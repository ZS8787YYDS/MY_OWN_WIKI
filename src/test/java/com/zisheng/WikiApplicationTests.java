package com.zisheng;

import com.zisheng.Mapper.EBookMapper;
import com.zisheng.Mapper.TestMapper;
import com.zisheng.Pojo.Entity.Ebook;
import com.zisheng.Pojo.Entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class WikiApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(WikiApplication.class);
    @Resource
    private TestMapper testMapper;
    @Resource
    private EBookMapper eBookMapper;
    @Test
    public void test_01()
    {
        User user = new User();
        user.setName("张三");
        user.setGender(1);
        user.setAge(21);
        testMapper.insert(user);
    }
    @Test
    public void test_02()
    {
        List<User> users = testMapper.selectAll();
        List<String> collect = users
                .stream()
                .map(user -> user.getName() + "_" + user.getAge())
                .collect(Collectors.toList());
        collect.forEach(log::info);

    }

    /**
     * 插入电子书
     */
    @Test
    public void insertEBook()
    {
        for(int i = 0;i < 10;i ++)
        {
            String tag = "_" + i;
            Ebook eBook = Ebook
                    .builder()
                    .name("SpringBoot基础入门" + tag)
                    .description("0基础，学id，月薪过万，就来黑马程序员")
                    .build();
            eBookMapper.insert(eBook);
        }
    }
}
