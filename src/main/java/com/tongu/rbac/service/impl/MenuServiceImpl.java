package com.tongu.rbac.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.tongu.rbac.constant.Constant;
import com.tongu.rbac.constant.StatusEnum;
import com.tongu.rbac.exception.RbacErrorCodeEnum;
import com.tongu.rbac.exception.RbacException;
import com.tongu.rbac.model.entity.MenuEntity;
import com.tongu.rbac.repository.MenuRepository;
import com.tongu.rbac.repository.RoleMenuRepository;
import com.tongu.rbac.service.MenuService;
import com.tongu.rbac.util.BeanUtil;

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
		if(Objects.isNull(menuEntity.getId())) {
			// 新增
			MenuEntity oldMenu = new MenuEntity();
			oldMenu.setMenuName(menuEntity.getMenuName());
			List<MenuEntity> existsList = menuRepository.findAll(Example.of(oldMenu));
			if(!CollectionUtils.isEmpty(existsList)) {
				throw new RbacException(RbacErrorCodeEnum.MENU_EXISTS);
			}
			
		} else {
			// 编辑
			Optional<MenuEntity> optional = menuRepository.findById(menuEntity.getId());
			if(!optional.isPresent()) {
				throw new RbacException(RbacErrorCodeEnum.MENU_NOT_EXISTS);
			}
			MenuEntity exists = optional.get();
			BeanUtil.copyPropertiesIgnoreNull(menuEntity, exists);
			menuEntity = exists;
		}
		
		MenuEntity max = menuRepository.findTopByOrderByMenuCodeDesc();
		menuEntity.setMenuCode(String.format("%05d", Integer.valueOf(max.getMenuCode()) + 1));
		
		String parentId = Constant.MENU_ROOT_ID;
		if(StringUtils.isEmpty(menuEntity.getParentId()) || Constant.MENU_ROOT_ID.equals(menuEntity.getParentId())) { // 父级是根目录
			menuEntity.setMenuLevel(1);
			menuEntity.setParentId("0");
			menuEntity.setSearchCode("");
		}
		else {
			Optional<MenuEntity> parentMenuEntity = menuRepository.findById(menuEntity.getParentId());
			if(!parentMenuEntity.isPresent()) {
				throw new RbacException("所选父级菜单不存在");
			}
			menuEntity.setMenuLevel(parentMenuEntity.get().getMenuLevel() + 1);
			parentId = parentMenuEntity.get().getId();
			menuEntity.setSearchCode(parentMenuEntity.get().getSearchCode());
		}
		
		MenuEntity sort = new MenuEntity();
		sort.setParentId(parentId);
		List<MenuEntity> sorts = menuRepository.findAll(Example.of(sort));
		menuEntity.setMenuSort(sorts.size() + 1);
		
		menuEntity.setSearchCode(new StringBuilder().append(menuEntity.getSearchCode()).append("|").append(menuEntity.getMenuCode()).toString());

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
		entity = Optional.ofNullable(entity).orElse(new MenuEntity());
		entity.setRecordStatus(StatusEnum.ENABLED.getValue());
		entity.setIsEnabled(StatusEnum.ENABLED.getValue());
		Example<MenuEntity> example = Example.of(entity, matcher);
		Sort sort = Sort.by(Order.asc("menuLevel"), Order.asc("menuSort"));
		PageRequest pageRequest = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);
		Page<MenuEntity> pageList = menuRepository.findAll(example, pageRequest);
		return pageList;
	}

}
