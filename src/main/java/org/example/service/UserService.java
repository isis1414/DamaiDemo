package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.User;
import org.example.exception.DaMaiFrameException;
import org.example.mapper.UserMapper;
import org.example.pojo.BaseCode;
import org.example.pojo.dto.UserLoginDto;
import org.example.pojo.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;
    public UserLoginDto login(UserLoginDto userLoginDto){
        UserLoginVo userLoginVo = new UserLoginVo();
        String code = userLoginDto.getCode();
        String mobile = userLoginDto.getMobile();
        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();
        if (StringUtils.isEmpty(mobile) && StringUtils.isEmpty(email)) {
            throw new DaMaiFrameException(BaseCode.USER_MOBILE_AND_EMAIL_NOT_EXIST);
        }

        return userLoginVo;
    }

}
