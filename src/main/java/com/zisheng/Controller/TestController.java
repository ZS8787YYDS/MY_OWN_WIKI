package com.zisheng.Controller;

import com.zisheng.ResponseResult.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
@Slf4j
public class TestController {
    @GetMapping("/test")
    @ApiOperation(value = "字符串测试接口")
    public Result<String> test_01()
    {
        return Result.success("ZiSheng8787");
    }
}
