package com.tongu.rbac.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tongu.rbac.constant.Constant;
import com.tongu.rbac.exception.RbacException;
import com.tongu.rbac.model.entity.MenuEntity;
import com.tongu.rbac.repository.MenuRepository;
import com.tongu.rbac.repository.RoleMenuRepository;
import com.tongu.rbac.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private RoleMenuRepository roleMenuRepository;
	
	@Override
	public List<MenuEntity> queryByRoleId(String roleId) {
		return roleMenuRepository.findByRoleId(roleId);
	}

	@Override
	public List<MenuEntity> queryByUserId(String userId) {
		return roleMenuRepository.findByUserId(userId);
	}

	@Override
	public void saveMenu(MenuEntity menuEntity)  {		
		if(StringUtils.isEmpty(menuEntity.getParentId()) || Constant.MENU_ROOT_ID.equals(menuEntity.getParentId())) { // 父级是根目录
			menuEntity.setMenuLevel(1);
			menuEntity.setParentId("0");
		}
		else {
			Optional<MenuEntity> parentMenuEntity = menuRepository.findById(menuEntity.getParentId());
			if(!parentMenuEntity.isPresent()) {
				throw new RbacException("所选父级菜单不存在");
			}
			menuEntity.setMenuLevel(parentMenuEntity.get().getMenuLevel() + 1);
		}
		menuRepository.save(menuEntity);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void deleteMenu(Set<String> ids)  {
		roleMenuRepository.batchDeleteByMenuId(ids);
		menuRepository.batchDelete(ids);
	}

	@Override
	public MenuEntity queryById(String id) {
		return menuRepository.findById(id).orElse(null);
	}

	@Override
	public Page<MenuEntity> queryAll(MenuEntity entity, Pageable page) {
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("menuName", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<MenuEntity> example = Example.of(Optional.ofNullable(entity).orElse(new MenuEntity()), matcher);
		Page<MenuEntity> pageList = menuRepository.findAll(example, page);
		return pageList;
	}

}
