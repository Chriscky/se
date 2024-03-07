package com.example.demo.constant;

import com.example.demo.utils.Pair;

/**
 * 错误码
 * @description 通用错误码
 */
public class StatusCode {

	/**
	 * 请求成功返回
	 */
	public static final Pair<Integer, String> OK = new Pair<>(0, "请求成功");
	/**
	 * 请求成功返回
	 */
	public static final Pair<Integer, String> DATABASE_OPERATION_FAILURE = new Pair<>(900, "数据库操作失败");
	/**
	 * 此次操作为登录
	 */
	public static final Pair<Integer, String> LOGIN = new Pair<>(3001, "请输入密码以完成登录");

	/**
	 * 此次操作为注册
	 */
	public static final Pair<Integer, String> REGISTER = new Pair<>(3002, "请设置密码以完成注册");

	/**
	 * 兜底处理的异常
	 */
	public static final Pair<Integer, String> INTERNAL_SERVER_ERROR = new Pair<>(1000, "网络异常");
	/**
	 * 参数异常，包括类型异常和未特殊处理的异常
	 */
	public static final Pair<Integer, String> PARAMETER_ERROR = new Pair<>(1001, "参数异常");
	/**
	 * 用户操作过于频繁，超出次数限制
	 */
	public static final Pair<Integer, String> REQUEST_TIME_LIMIT = new Pair<>(1002, "请稍后尝试");
	/**
	 * 用户没有登录
	 */
	public static final Pair<Integer, String> AUTHORIZATION_ERROR = new Pair<>(1003, "请先登录");

	/**
	 * 用户名或密码错误
	 */
	public static final Pair<Integer, String> LOGIN_ERROR = new Pair<>(1004, "手机号或密码错误");

	/**
	 * 用户通过修改参数中的userId访问不属于他的资源
	 */
	public static final Pair<Integer, String> MODIFIED_USERID = new Pair<>(2001, "非法访问，请勿使用他人id");


	/**
	 * 权限
	 */
	public static final Pair<Integer, String> PERMISSION_ERROR = new Pair<>(1005, "用户权限不足");


	private StatusCode() {

	}
}
