package com.zisheng.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zisheng.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<User> {
//    @Select("select * from tb_user")
    List<User> selectAll();
}
