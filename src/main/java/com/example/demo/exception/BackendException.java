package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zhangjingqi
 * @date 最后一次更新于 2023/06/06
 * @description 后台自定义异常
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class BackendException extends RuntimeException {

	private final int code;

	public BackendException(int code, String message) {
		super(message);
		this.code = code;
	}

	public BackendException(int code) {
		super();
		this.code = code;
	}

	public BackendException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public BackendException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}
}

