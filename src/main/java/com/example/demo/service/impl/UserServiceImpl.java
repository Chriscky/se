package com.example.demo.service.impl;

import com.example.demo.config.JwtConfig;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.PO.UserPO;
import com.example.demo.entity.VO.user.LoginVO;
import com.example.demo.entity.VO.user.RegisterVO;
import com.example.demo.entity.VO.user.UserBaseInfoVO;
import com.example.demo.entity.VO.user.UserInfoVO;
import com.example.demo.enums.GenderEnum;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final JwtConfig jwtConfig;



    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(JwtConfig jwtConfig,  UserMapper userMapper) {
        this.jwtConfig = jwtConfig;

        this.userMapper = userMapper;
    }


    @Override
    public boolean register(RegisterVO registerVO) {
        UserPO userPO = userMapper.findUserByPhone(registerVO.getPhone());
        if(userPO != null){
            return false;
        }

        userPO = userMapper.findUserByUsername(registerVO.getUsername());
        if(userPO != null){
            return false;
        }

        userPO = UserPO.builder()
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .password(registerVO.getPassword())
                .username(registerVO.getUsername())
                .phone(registerVO.getPhone())
                .avatar(registerVO.getAvatar())
                .build();

        userMapper.saveUser(userPO);


        return true;
    }

    @Override
    public Integer loginOrRegisterCheckPhone(LoginVO loginVO) {
        return null;
    }

    @Override
    public UserBaseInfoVO loginOrRegisterCheckPassword(LoginVO loginVO) {
        return null;
    }

    @Override
    public UserBaseInfoVO login(LoginVO loginVO) {
        UserPO userPO = userMapper.findUserByUsername(loginVO.getUsername());
        if(userPO==null || !userPO.getPassword().equals(loginVO.getPassword())){
            return null;
        }
        String jwtToken = jwtConfig.createJwt(userPO);
        return UserBaseInfoVO.builder()
                .userId(userPO.getId())
                .jwtToken(jwtToken)
                .avatar(userPO.getAvatar())
                .phone(userPO.getPhone())
                .username(userPO.getUsername())
                .build();
    }

    @Override
    public UserInfoVO getUserInfo(Integer userId) {
        UserPO userPO = userMapper.findUserByUserId(userId);
        return UserInfoVO.builder()
                .id(userPO.getId())
                .phone(userPO.getPhone())
                .username(userPO.getUsername())
                .avatar(userPO.getAvatar())
                .gender(userPO.getGender())
                .email(userPO.getEmail())
                .birthday(userPO.getBirthday() == null ? null : userPO.getBirthday().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .region(userPO.getRegion())
                .intro(userPO.getIntro())
                .build();
    }

    @Override
    public void updateUserInfo(UserInfoVO userInfoVO) {
        UserPO userPO = UserPO.builder()
                .id(userInfoVO.getId())
                .phone(userInfoVO.getPhone())
                .username(userInfoVO.getUsername())
                .avatar(userInfoVO.getAvatar())
                .gender(GenderEnum.getTypeByValue(userInfoVO.getGender()))
                .email(userInfoVO.getEmail())
                .birthday(userInfoVO.getBirthday() == null ? null : LocalDate.parse(userInfoVO.getBirthday(), java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .region(userInfoVO.getRegion())
                .intro(userInfoVO.getIntro())
                .updatedAt(System.currentTimeMillis())
                .build();

        userMapper.updateUser(userPO);
    }
}
