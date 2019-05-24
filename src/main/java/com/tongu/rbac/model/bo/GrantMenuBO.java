package com.tongu.rbac.model.bo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GrantMenuBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7616450977337954832L;

	private String grantRoleId;
	
	private List<String> menuIds;
	
	private String updateUserId;
}
