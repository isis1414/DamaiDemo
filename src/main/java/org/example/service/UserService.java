package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.example.common.enums.RedisKeyManage;
//import org.example.common.redis.RedisKeyBuild;
import org.example.entity.User;
import org.example.exception.DaMaiFrameException;
import org.example.mapper.UserMapper;
import org.example.common.enums.BaseCode;
import org.example.pojo.dto.UserLoginDto;
import org.example.pojo.vo.UserVo;
import org.example.tool.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {
//    @Autowired
//    private RedisCache redisCache;
    public UserVo login(UserLoginDto userLoginDto){
        UserVo userLoginVo = new UserVo();
        String code = userLoginDto.getCode();
        String mobile = userLoginDto.getMobile();
        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();
        if (StringUtils.isEmpty(mobile) && StringUtils.isEmpty(email)) {
             throw new DaMaiFrameException(BaseCode.USER_MOBILE_AND_EMAIL_NOT_EXIST);
        }
        User user = null;
        if (StringUtils.isNotEmpty(mobile)) {
            user = this.lambdaQuery().eq(User::getMobile, mobile).one();
        } else if (StringUtils.isNotEmpty(email)) {
            user = this.lambdaQuery().eq(User::getEmail, email).one();
        }


        // TODO: 密码校验逻辑

        return userLoginVo;
    }
    @Cacheable(
            cacheNames = "userCache",
            key = "#p0"
    )
    public UserVo getUserById(Long userId) {

        System.out.println("👉 查数据库 userId=" + userId);
        User user = this.getById(userId);
        if (Objects.isNull(user)) {
            throw new DaMaiFrameException(BaseCode.USER_EMPTY);
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}
