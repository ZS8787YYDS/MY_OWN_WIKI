package com.zisheng.Service.Impls;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zisheng.Mapper.TestMapper;
import com.zisheng.Pojo.User;
import com.zisheng.Service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, User> implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public List<User> selectAll() {
        return testMapper.selectAll();
    }
}
