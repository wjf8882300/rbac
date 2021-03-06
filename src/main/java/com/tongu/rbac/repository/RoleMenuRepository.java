package com.tongu.rbac.repository;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.tongu.rbac.model.entity.MenuEntity;
import com.tongu.rbac.model.entity.RoleMenuEntity;


/**   
 * 数据访问接口
 *  
 * @author  Tool
 * @version $Revision:1.0.0, $Date: 2016-05-16 14:14:57 $ 
 */
public interface RoleMenuRepository extends Repository<RoleMenuEntity, String>, JpaRepository<RoleMenuEntity,String>{

	/**
	 * 通过RoleId查询菜单
	 * @param roleId
	 * @return
	 */
	@Query("select A from MenuEntity A where A.id in ("
			+ "select B.menuId from RoleMenuEntity B where B.roleId = :roleId)")
	public List<MenuEntity> findByRoleId(@Param("roleId") String roleId);
	
	/**
	 * 通过用户ID查询菜单
	 * 
	 * @param userId
	 * @return
	 */
	@Query("select A from MenuEntity A where A.id in ("
			+ "select B.menuId from RoleMenuEntity B where B.roleId in ("
			+ "select C.roleId from UserRoleEntity C where C.userId = :userId)"
			+ ") and A.isEnabled = '0'")
	public List<MenuEntity> findByUserId(@Param("userId") String userId);
	
	/**
	 * 通过RoleId删除菜单
	 * 
	 * @param roleId
	 * @return
	 */
	@Modifying
	@Query("delete from RoleMenuEntity A where A.roleId = :roleId")
	public int deleteByRoleId(@Param("roleId") String roleId);
	
	/**
	 * 通过MenuId删除菜单
	 * 
	 * @param roleId
	 * @return
	 */
	@Modifying
	@Query("delete from RoleMenuEntity A where A.menuId = :menuId")
	public int deleteByMenuId(@Param("menuId") String menuId);
	
	/**
	 * 批量通过MenuId删除菜单
	 * 
	 * @param menuId
	 * @return
	 */
	@Modifying
	@Query("delete from RoleMenuEntity A where A.menuId in (:menuIds)")
	public int batchDeleteByMenuId(@Param("menuIds") Set<String> menuId);
	
	/**
	 * 批量通过RoleId删除菜单
	 * 
	 * @param roleId
	 * @return
	 */
	@Modifying
	@Query("delete from RoleMenuEntity A where A.roleId in (:roleId)")
	public int batchDeleteByRoleId(@Param("roleId") Set<String> roleId);
}
