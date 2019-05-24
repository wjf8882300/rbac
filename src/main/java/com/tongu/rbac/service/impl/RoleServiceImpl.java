package com.tongu.rbac.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.tongu.rbac.exception.RbacException;
import com.tongu.rbac.model.bo.GrantMenuBO;
import com.tongu.rbac.model.entity.RoleEntity;
import com.tongu.rbac.model.entity.RoleMenuEntity;
import com.tongu.rbac.repository.RoleMenuRepository;
import com.tongu.rbac.repository.RoleRepository;
import com.tongu.rbac.repository.UserRoleRepository;
import com.tongu.rbac.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleMenuRepository roleMenuRepository;
	
	@Override
	public List<RoleEntity> queryByUserId(String userId) {
		return userRoleRepository.findByUserId(userId);
	}

	@Override
	public Page<RoleEntity> queryAll(RoleEntity entity, Pageable page) {
		Page<RoleEntity> pageList = roleRepository.findAll(Example.of(entity), page);
		return pageList;
	}

	@Transactional(readOnly = false, rollbackFor = RbacException.class)
	@Override
	public void saveRole(RoleEntity roleEntity){
		roleRepository.save(roleEntity);
	}

	@Transactional(readOnly = false, rollbackFor = RbacException.class)
	@Override
	public void deleteRole(Set<String> ids){
		roleMenuRepository.batchDeleteByRoleId(ids);
		userRoleRepository.batchDeleteByRoleId(ids);
		roleRepository.batchDelete(ids);
	}

	@Override
	public RoleEntity queryById(String id) {
		return roleRepository.findById(id).orElse(null);
	}

	@Transactional(readOnly = false, rollbackFor = RbacException.class)
	@Override
	public void grantRole(GrantMenuBO grantMenu){		
		// 删除原先权限
		roleMenuRepository.deleteByRoleId(grantMenu.getGrantRoleId());
		
		// 分配新的权限
		List<RoleMenuEntity> roleMenuList = Lists.newArrayList();
		for(String id : grantMenu.getMenuIds()) {
			RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
			roleMenuEntity.setMenuId(id);
			roleMenuEntity.setRoleId(grantMenu.getGrantRoleId());
			roleMenuEntity.setBasicModelProperty(grantMenu.getUpdateUserId(), true);
			roleMenuList.add(roleMenuEntity);
		}
		roleMenuRepository.saveAll(roleMenuList);
	}

}
