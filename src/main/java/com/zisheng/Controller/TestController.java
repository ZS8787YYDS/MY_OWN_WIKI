package com.zisheng.Controller;

import com.zisheng.Pojo.User;
import com.zisheng.ResponseResult.Result;
import com.zisheng.Service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
@Api(tags = "测试相关接口")
@Slf4j
public class TestController {
    @Resource
    private TestService testService;
    @GetMapping
    @ApiOperation(value = "字符串测试")
    public Result<String> test_01()
    {
        return Result.success("ZiSheng8787");
    }
    @GetMapping("/users")
    @ApiOperation(value = "员工查询测试")
    public Result<List<User>> selectAll()
    {
        List<User> users = testService.selectAll();
        return Result.success(users);
    }
}
