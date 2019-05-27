package com.tongu.rbac.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.tongu.rbac.exception.RbacErrorCodeEnum;
import com.tongu.rbac.exception.RbacException;
import com.tongu.rbac.model.bo.GrantMenuBO;
import com.tongu.rbac.model.entity.RoleEntity;
import com.tongu.rbac.model.entity.RoleMenuEntity;
import com.tongu.rbac.repository.RoleMenuRepository;
import com.tongu.rbac.repository.RoleRepository;
import com.tongu.rbac.repository.UserRoleRepository;
import com.tongu.rbac.service.RoleService;
import com.tongu.rbac.util.BeanUtil;

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
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("roleName", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<RoleEntity> example = Example.of(Optional.ofNullable(entity).orElse(new RoleEntity()), matcher);
		Page<RoleEntity> pageList = roleRepository.findAll(example, page);
		return pageList;
	}

	@Transactional(readOnly = false, rollbackFor = RbacException.class)
	@Override
	public void saveRole(RoleEntity roleEntity){
		if(Objects.isNull(roleEntity.getId())) {
			RoleEntity oldRole = new RoleEntity();
			oldRole.setRoleName(roleEntity.getRoleName());
			List<RoleEntity> existsList = roleRepository.findAll(Example.of(oldRole));
			if(!CollectionUtils.isEmpty(existsList)) {
				throw new RbacException(RbacErrorCodeEnum.USER_EXISTS);
			}
		} else {
			Optional<RoleEntity> optional = roleRepository.findById(roleEntity.getId());
			if(!optional.isPresent()) {
				throw new RbacException(RbacErrorCodeEnum.USER_NOT_EXISTS);
			}
			RoleEntity exists = optional.get();
			BeanUtil.copyPropertiesIgnoreNull(roleEntity, exists);
			roleEntity = exists;
		}
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
