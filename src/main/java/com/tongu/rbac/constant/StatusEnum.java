package com.tongu.rbac.constant;

import lombok.Getter;

public enum StatusEnum {

	ENABLED("0", "启用"),
	DISABLED("1", "禁用")
	;
	
	/** 值 */
	@Getter
	private String value;

	/** 说明 */
	@Getter
	private String intro;


	private StatusEnum(String value, String intro) {
		this.value = value;
		this.intro = intro;
	}

}
