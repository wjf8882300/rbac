/** 
 * @(#)UserServiceImpl.java 1.0.0 2016年5月16日 下午2:45:27  
 *  
 * Copyright © 2016 善林金融.  All rights reserved.  
 */ 

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.tongu.rbac.constant.Constant;
import com.tongu.rbac.exception.RbacErrorCodeEnum;
import com.tongu.rbac.exception.RbacException;
import com.tongu.rbac.model.bo.GrantRoleBO;
import com.tongu.rbac.model.entity.UserEntity;
import com.tongu.rbac.model.entity.UserRoleEntity;
import com.tongu.rbac.repository.UserRepository;
import com.tongu.rbac.repository.UserRoleRepository;
import com.tongu.rbac.service.UserService;
import com.tongu.rbac.util.BeanUtil;

/**   
 * 用户接口实现类
 *  
 * @author  wangjf
 * @version $Revision:1.0.0, $Date: 2016年5月16日 下午2:45:27 $ 
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserEntity queryById(String id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public UserEntity queryByLoginName(String loginName){
		return userRepository.findByLoginName(loginName);
	}

	@Override
	public Page<UserEntity> queryAll(UserEntity entity, Pageable page) {
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("loginName", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<UserEntity> example = Example.of(Optional.ofNullable(entity).orElse(new UserEntity()), matcher);
		Page<UserEntity> pageList = userRepository.findAll(example, page);
		return pageList;
	}

	@Transactional(readOnly = false)
	@Override
	public void saveUser(UserEntity userEntity) {
		if(Objects.isNull(userEntity.getId())) {
			UserEntity oldUser = new UserEntity();
			oldUser.setLoginName(userEntity.getLoginName());
			List<UserEntity> existsList = userRepository.findAll(Example.of(oldUser));
			if(!CollectionUtils.isEmpty(existsList)) {
				throw new RbacException(RbacErrorCodeEnum.USER_EXISTS);
			}
		} else {
			Optional<UserEntity> optional = userRepository.findById(userEntity.getId());
			if(!optional.isPresent()) {
				throw new RbacException(RbacErrorCodeEnum.USER_NOT_EXISTS);
			}
			UserEntity exists = optional.get();
			BeanUtil.copyPropertiesIgnoreNull(userEntity, exists);
			userEntity = exists;
		}
		userEntity.setLoginPassword(passwordEncoder.encode(userEntity.getLoginPassword()));
		userRepository.save(userEntity);
	}


	@Transactional(readOnly = false)
	@Override
	public void deleteUser(Set<String> ids) {
		if(ids.contains(Constant.SUPPER_ADMIN_ID)) {
			throw new RbacException(RbacErrorCodeEnum.SUPER_USER_CANNOT_DELETE); 
		}
		userRoleRepository.batchDeleteByUserId(ids);
		userRepository.batchDelete(ids);
	}

	@Transactional(readOnly = false)
	@Override
	public void grantRole(GrantRoleBO grantRole) {		
		// 删除原先角色
		userRoleRepository.batchDeleteByUserId(Sets.newHashSet(grantRole.getGrantUserId()));
		
		// 分配新的角色
		List<UserRoleEntity> userRoleList = Lists.newArrayList();
		for(String id : grantRole.getRoleIds()) {
			UserRoleEntity userRoleEntity = new UserRoleEntity();
			userRoleEntity.setUserId(grantRole.getGrantUserId());
			userRoleEntity.setRoleId(id);
			userRoleEntity.setBasicModelProperty(grantRole.getUpdateUserId(), true);
			userRoleList.add(userRoleEntity);
		}
		userRoleRepository.saveAll(userRoleList);
	}
}
