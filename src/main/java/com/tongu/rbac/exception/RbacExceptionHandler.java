package com.tongu.rbac.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tongu.rbac.model.vo.BaseVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常处理
 * @author wangjf
 *
 */
@RestControllerAdvice
@Slf4j(topic = "error")
public class RbacExceptionHandler {

	@ExceptionHandler(value = RbacException.class)
	public BaseVO<String> processMatchException(RbacException ex) {
		log.warn("processMatchException {}", ex);
		return new BaseVO<String>(ex.getCode(), ex.getMessage(), null);
	}
	
	@ExceptionHandler(value = Exception.class)
	public BaseVO<String> processMatchException(Exception ex) {
		log.warn("processMatchException {}", ex);
		return new BaseVO<String>(500, ex.getMessage(), null);
	}
	
	@ExceptionHandler(value = AuthenticationException.class)
	public BaseVO<String> processMatchException(AuthenticationException ex) {
		log.warn("processMatchException {}", ex);
		return new BaseVO<String>(403, ex.getMessage(), null);
	}
}
