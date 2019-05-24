package com.tongu.rbac.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tongu.rbac.model.bo.GrantMenuBO;
import com.tongu.rbac.model.entity.RoleEntity;

public interface RoleService {

	/**
	 * 通过用户ID查询角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<RoleEntity> queryByUserId(String userId);
	
	/**
	 * 查询所有的角色
	 *  
	 * @param params
	 * @return
	 */
	public Page<RoleEntity> queryAll(RoleEntity entity, Pageable page);
	
	/**
	 * 保存角色
	 * 
	 * @param params
	 * @return
	 */
	public void saveRole(RoleEntity entity);
	
	/**
	 * 删除角色
	 * 
	 * @param params
	 * @return
	 */
	public void deleteRole(Set<String> ids);
	
	/**
	 * 通过ID查询
	 *
	 * @author  wangjf
	 * @date    2016年5月16日 下午2:44:24
	 * @param id
	 * @return
	 */
	public RoleEntity queryById(String id);
	
	/**
	 * 分配权限
	 * 
	 * @param params
	 * @return
	 * @throws JJException
	 */
	public void grantRole(GrantMenuBO grantMenu);
}
