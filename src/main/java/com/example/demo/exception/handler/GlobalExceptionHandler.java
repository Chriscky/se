package com.example.demo.exception.handler;

import com.example.demo.constant.StatusCode;
import com.example.demo.wrapper.Result;
import lombok.extern.log4j.Log4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangjingqi
 */
@RestControllerAdvice(basePackages = {"com.everlasting.demo.controller"})
@Order(1)
@Log4j
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	private Result<Void> handleGlobalException(Exception e) {
		log.error(e.getMessage());
		return new Result<>(StatusCode.INTERNAL_SERVER_ERROR.getKey(), StatusCode.INTERNAL_SERVER_ERROR.getValue(), null);
	}
}
