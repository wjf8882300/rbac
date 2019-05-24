package com.tongu.rbac.model.bo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录信息
 * 
 * @author wangjf
 * @date    2019年4月1日 上午10:36:54
 */
@ApiModel("登录信息")
@Data
public class LoginBO implements Serializable {
	/**@Fields serialVersionUID */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("用户名")
	private String username;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("自动登录[0-非自动/1-自动]")
	private Integer auto;
}
