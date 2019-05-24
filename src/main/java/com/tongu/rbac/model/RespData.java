package com.tongu.rbac.model;

/**
 * 响应数据
 */
public class RespData<T> {

	/** 响应码 */
	private Integer code;

	/** 响应消息 */
	private String message;

	/** 响应数据 */
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RespData() {
		super();
	}

	public RespData(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

}
