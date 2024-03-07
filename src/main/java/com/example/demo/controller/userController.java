package com.example.demo.controller;


import com.example.demo.constant.StatusCode;
import com.example.demo.entity.VO.user.LoginVO;
import com.example.demo.entity.VO.user.RegisterVO;
import com.example.demo.entity.VO.user.UserBaseInfoVO;
import com.example.demo.entity.VO.user.UserInfoVO;
import com.example.demo.service.UserService;
import com.example.demo.utils.JWTUtils;
import com.example.demo.wrapper.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;

@RestController
@RequestMapping("/api/v1")
public class userController {

    private final JWTUtils jwtUtils;

    private final UserService userService;

    @Autowired
    public userController(JWTUtils jwtUtils, UserService userService) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    /**
     * 手机号密码登录
     *
     * @param loginVo 登录参数
     */
    @PostMapping("/user/login")
    public Result<UserInfoVO> passwordLogin(@RequestBody LoginVO loginVo,
                                            HttpServletResponse response) {
        UserBaseInfoVO userBaseInfoVO = userService.login(loginVo);
        if(userBaseInfoVO == null){
            return Result.buildFailed(StatusCode.LOGIN_ERROR.getKey(),StatusCode.LOGIN_ERROR.getValue());
        }
        String jwt = userBaseInfoVO.getJwtToken();
        // 添加cookie
        ResponseCookie cookie = createCookie(jwt);
//		response.addHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.SET_COOKIE);
//		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        response.addHeader("X-SET-COOKIE", cookie.toString());
        return Result.buildSuccess(UserInfoVO.builder()
                .username(userBaseInfoVO.getUsername())
                .avatar(userBaseInfoVO.getAvatar())
                .id(userBaseInfoVO.getUserId())
                        .phone(userBaseInfoVO.getPhone())
                .build());
    }

    @PostMapping("/user/register")
    public Result<Boolean> register(@RequestBody RegisterVO registerVO){
        boolean registerResult = userService.register(registerVO);
        return Result.buildSuccess(registerResult);
    }

    @GetMapping("/user/{userId}/info")
    public Result<UserInfoVO> getUserInfo(@PathVariable(value = "userId") Integer userId){

        return Result.buildSuccess(userService.getUserInfo(userId));
    }

    @PutMapping("/user/info")
    public Result<Void> updateUserInfo(@RequestBody UserInfoVO userInfoVO) {
        userService.updateUserInfo(userInfoVO);

        return Result.buildSuccess();
    }

    private ResponseCookie createCookie(String jwtToken) {
        // 使用JWT Token创建一个ResponseCookie对象，并设置cookie的名称和值
        // "jwt"是cookie的名称，jwtToken是JWT Token的值
        return ResponseCookie.from("jwt", jwtToken)
                // 设置cookie为httpOnly，这样JavaScript无法通过document.cookie来访问该cookie
                .httpOnly(true)
                // 设置cookie为secure，这样只有在HTTPS连接下才会发送该cookie
                .secure(true)
                // 设置cookie的路径，这里设置为根路径
                .path("/")
                // 设置cookie的过期时间，这里设置为30天
                .maxAge(Duration.ofDays(30))
                // 设置cookie的SameSite属性，可以防止CSRF攻击
                .sameSite("None")
                // 构建ResponseCookie对象并返回
                .build();
    }
}
