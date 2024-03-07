package com.example.demo.entity.VO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjingqi
 * @desctiption 注册参数对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterVO {

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 头像url
	 */
	private String avatar;
}
