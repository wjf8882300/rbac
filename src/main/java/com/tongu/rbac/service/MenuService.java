package com.tongu.rbac.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tongu.rbac.model.entity.MenuEntity;

public interface MenuService {

	/**
	 * 通过角色ID查询菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public List<MenuEntity> queryByRoleId(String roleId);
	
	/**
	 * 通过用户ID查询菜单
	 * 
	 * @param userId
	 * @return
	 */
	public List<MenuEntity> queryByUserId(String userId);
	
	/**
	 * 查询所有
	 * 
	 * @param params
	 * @return
	 * @
	 */
	public Page<MenuEntity> queryAll(MenuEntity entity, Pageable page);
	
	/**
	 * 保存菜单
	 * 
	 * @param menuEntity
	 * @return
	 */
	public void saveMenu(MenuEntity menuEntity) ;
	
	/**
	 * 删除菜单
	 * 
	 * @param params
	 * @return
	 */
	public void deleteMenu(Set<String> ids) ;
	
	/**
	 * 通过ID查询
	 *
	 * @author  wangjf
	 * @date    2016年5月16日 下午2:44:24
	 * @param id
	 * @return
	 */
	public MenuEntity queryById(String id);
}
