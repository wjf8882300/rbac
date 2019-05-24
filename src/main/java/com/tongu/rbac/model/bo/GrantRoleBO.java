package com.tongu.rbac.model.bo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GrantRoleBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7616450977337954832L;

	private String grantUserId;
	
	private List<String> roleIds;
	
	private String updateUserId;
}
