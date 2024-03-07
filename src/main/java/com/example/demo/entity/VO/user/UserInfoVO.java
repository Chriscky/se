package com.example.demo.entity.VO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author zhangjingqi
 * @desctiption 用户信息VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoVO {

	/**
	 * 用户id
	 */
	private Integer id;
	/**
	 * 用户手机号
	 */
	private String phone;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 头像链接
	 */
	private String avatar;
	/**
	 * 用户性别
	 */
	private String gender;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 用户生日
	 */
	private String birthday;
	/**
	 * 用户地区
	 */
	private String region;
	/**
	 * 用户简介
	 */
	private String intro;
}
