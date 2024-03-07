package com.example.demo.wrapper;

import com.example.demo.constant.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**

 * @description HTTP 响应包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> {

	/**
	 * 响应代码
	 */
	private Integer code;
	/**
	 * 返回的信息
	 */
	private String msg;
	/**
	 * 返回的结果（响应体）
	 */
	private T data;

	public static <T> Result<T> buildSuccess(T data) {
		return new Result<>(StatusCode.OK.getKey(), StatusCode.OK.getValue(), data);
	}

	public static Result<Void> buildSuccess() {
		return new Result<>(StatusCode.OK.getKey(), StatusCode.OK.getValue(), null);
	}

	public static <T> Result<T> buildSuccess(Integer code, String msg, T data) {
		return new Result<>(code, msg, data);
	}

	public static <T> Result<T> buildSuccess(Integer code, String msg) {
		return new Result<>(code, msg, null);
	}

	public static <T> Result<T> buildFailed(Integer code, Throwable e) {
		return new Result<>(code, e.getLocalizedMessage(), null);
	}

	public static <T> Result<T> buildFailed(Integer code, String message) {
		return new Result<>(code, message, null);
	}

}
