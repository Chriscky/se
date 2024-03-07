package com.example.demo.exception.handler;

import com.example.demo.exception.UserClientException;
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
@Order(0)
@Log4j
public class UserClientExceptionHandler {

	@ExceptionHandler(UserClientException.class)
	@ResponseBody
	private Result<Void> handleMyServiceException(UserClientException e) {
		return new Result<>(e.getCode(), e.getMessage(), null);
	}
}
