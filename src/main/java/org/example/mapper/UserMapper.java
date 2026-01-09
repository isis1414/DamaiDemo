package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jdk.jfr.MemoryAddress;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.User;
@Mapper
public  interface UserMapper extends BaseMapper<User> {

}
