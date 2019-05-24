/** 
 * @(#)UserService.java 1.0.0 2016年5月16日 下午2:42:40  
 *  
 * Copyright © 2016 善林金融.  All rights reserved.  
 */ 

package com.tongu.rbac.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tongu.rbac.model.bo.GrantRoleBO;
import com.tongu.rbac.model.entity.UserEntity;

/**   
 * 用户接口
 *  
 * @author  wangjf
 * @version $Revision:1.0.0, $Date: 2016年5月16日 下午2:42:40 $ 
 */
public interface UserService {

	/**
	 * 通过ID查询
	 *
	 * @author  wangjf
	 * @date    2016年5月16日 下午2:44:24
	 * @param id
	 * @return
	 */
	public UserEntity queryById(String id);
	
	/**
	 * 通过登录名查询用户
	 * 
	 * @param loginName
	 * @return
	 */
	public UserEntity queryByLoginName(String loginName);
	
	/**
	 * 查询所有用户
	 * 
	 * @param params
	 * @return
	 */
	public Page<UserEntity> queryAll(UserEntity entity, Pageable page);
	
	/**
	 * 保存用户
	 * 
	 * @param params
	 * @return
	 */
	public void saveUser(UserEntity userEntity);
	
	/**
	 * 删除用户
	 * 
	 * @param params
	 * @return
	 */
	public void deleteUser(Set<String> ids);
	
	/**
	 * 分配角色
	 */
	public void grantRole(GrantRoleBO grantRole);
}
