package com.zisheng.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zisheng.Pojo.User;

import java.util.List;

public interface TestService extends IService<User> {
    /**
     * 查询所有员工接口
     * @return
     */
    List<User> selectAll();
}
