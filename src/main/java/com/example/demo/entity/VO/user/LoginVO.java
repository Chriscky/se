package com.example.demo.entity.VO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjingqi
 * @desctiption 用户名、密码登录参数对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginVO {

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
}
