package com.tongu.rbac.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 * @author wangjf
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RbacException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2182599219191895632L;
	
	private Integer code;
	
	private String msg;

	public RbacException(RbacErrorCodeEnum error) {
		super(new StringBuilder().append(error.getCode()).append(":").append(error.getMsg()).toString());
		this.code = error.getCode();
		this.msg = error.getMsg();
	}
	
	public RbacException(RbacErrorCodeEnum error, String msg) {
		super(new StringBuilder().append(error.getCode()).append(":").append(msg).toString());
		this.code = error.getCode();
		this.msg = msg;
	}
	
	public RbacException(String message) {
		super(new StringBuilder().append(500).append(":").append(message).toString());
		this.code = 500;
		this.msg = message;
	}
}
