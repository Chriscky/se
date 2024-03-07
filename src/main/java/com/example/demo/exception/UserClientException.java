package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zhangjingqi
 * @date 最后一次更新于 2023/05/31
 * @description 用户端自定义异常
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserClientException extends RuntimeException {

	private final int code;

	public UserClientException(int code, String message) {
		super(message);
		this.code = code;
	}

	public UserClientException(int code) {
		super();
		this.code = code;
	}

	public UserClientException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public UserClientException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}
}

