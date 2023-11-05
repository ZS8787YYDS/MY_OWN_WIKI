package com.zisheng;

import cn.hutool.core.util.StrUtil;
import com.zisheng.Mapper.EBookMapper;
import com.zisheng.Mapper.TestMapper;
import com.zisheng.Pojo.Entity.Ebook;
import com.zisheng.Pojo.Entity.User;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

//@SpringBootTest
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
    @Test
    public void test_HuTool()
    {
        String s = "";
        System.out.println(s.isEmpty());
        System.out.println(StrUtil.isEmpty(s));
        System.out.println(StrUtil.isNotEmpty(s));
        System.out.println(StrUtil.isBlank(s));
        System.out.println("===========================");
        s = null;
        System.out.println(StrUtil.isEmpty(s));
        System.out.println(StrUtil.isNotEmpty(s));
        System.out.println(StrUtil.isBlank(s));
        System.out.println("===========================");
        System.out.println(StringUtils.isEmpty(s));
        System.out.println(StringUtils.isBlank(s));
        System.out.println(ObjectUtils.isEmpty(s));
    }
    @Test
    public void testBigDecimal()
    {
        BigDecimal bd1 = BigDecimal.valueOf(0.2);
        BigDecimal bd2 = BigDecimal.valueOf(0.20);
//        BigDecimal result = bd1.divide(bd2, 3, RoundingMode.HALF_UP);
        boolean re = bd1.equals(bd2);
        int result = bd1.compareTo(bd2);
        System.out.println(result);
        System.out.println(re);
    }
    @Test
    public void testBigInteger()
    {
        BigInteger bi1 = new BigInteger("425242311111111111111111111111111111111111");
        BigInteger bi2 = new BigInteger("453533333333333555555555555555555555555555555");
        BigInteger result = bi1.multiply(bi2);
        System.out.println(result);
    }
}
