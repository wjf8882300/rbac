package com.tongu.rbac.repository;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.tongu.rbac.model.entity.MenuEntity;


/**   
 * 数据访问接口
 *  
 * @author  Tool
 * @version $Revision:1.0.0, $Date: 2016-05-16 14:14:57 $ 
 */
public interface MenuRepository extends Repository<MenuEntity, String>, JpaRepository<MenuEntity,String>{

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@Modifying
	@Query("delete from MenuEntity A where A.id in (:ids)")
	public int batchDelete(@Param("ids")Set<String> ids);
	
	public MenuEntity findTopByOrderByMenuCodeDesc();
}
