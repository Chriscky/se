package com.example.demo.service;


import com.example.demo.entity.VO.user.LoginVO;
import com.example.demo.entity.VO.user.RegisterVO;
import com.example.demo.entity.VO.user.UserBaseInfoVO;
import com.example.demo.entity.VO.user.UserInfoVO;

public interface UserService {
    /**
     * 注册
     * @param registerVO 用户注册信息VO
     * @return 是否注册成功
     */
    boolean register(RegisterVO registerVO);

    /**
     * 对用户登录/注册时的phone做处理
     *
     * @param loginVO 登录/注册参数，这里只用到它的phone字段
     * @return 本次操作的结果
     */
    Integer loginOrRegisterCheckPhone(LoginVO loginVO);


    /**
     * 对用户登录/注册时的password做处理
     *
     * @param loginVO 登录/注册参数，这里只用到它的phone字段
     * @return 用户信息
     */
    UserBaseInfoVO loginOrRegisterCheckPassword(LoginVO loginVO);

    /**
     * 用户名密码登录
     * @param loginVO
     * @return
     */
    UserBaseInfoVO login(LoginVO loginVO);

    /**
     * 用户获取个人信息
     * @param userId 用户Id
     * @return 用户信息
     */
    UserInfoVO getUserInfo(Integer userId);

    /**
     * 更新用户信息
     *
     * @param userInfoVO 待更新的信息
     */
    void updateUserInfo(UserInfoVO userInfoVO);

}
