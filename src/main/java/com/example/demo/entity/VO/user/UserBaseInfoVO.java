package com.example.demo.entity.VO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjingqi
 * @desctiption 登录返回的用户基本信息VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBaseInfoVO {

	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 用户手机号
	 */
	private String phone;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * jwtToken
	 */
	private String jwtToken;
	/**
	 * 用户头像URL
	 */
	private String avatar;
}
