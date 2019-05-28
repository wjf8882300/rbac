package com.tongu.rbac.security;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.tongu.rbac.constant.Constant;
import com.tongu.rbac.constant.StatusEnum;
import com.tongu.rbac.model.entity.MenuEntity;
import com.tongu.rbac.model.entity.UserEntity;
import com.tongu.rbac.service.MenuService;
import com.tongu.rbac.service.UserService;


/**
 * 用户详情服务
 * @author zhangyx
 *
 */
@Service("webUserDetailsService")
public class WebUserDetailsService implements UserDetailsService {
	public static final Logger logger = LoggerFactory.getLogger(WebUserDetailsService.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = null;
		try {
			userEntity = userService.queryByLoginName(username);
		} catch (Exception e) {
			logger.error(username+"--〉 登录失败 " + e);
			throw new BadCredentialsException("系统异常，请稍后重试！");
		}
		
		if(userEntity!=null) {
			if(!StatusEnum.ENABLED.getValue().equals(userEntity.getRecordStatus())) {
				throw new BadCredentialsException("该用户已失效，请联系管理员！");
			}
			
			// 设置用户权限
			Set<GrantedAuthority> auths = Sets.newConcurrentHashSet();		
			List<MenuEntity> menuList = null;
			if(Constant.SUPPER_ADMIN_ID.equals(userEntity.getId())) { 
				// 超级管理员赋予所有权限
				Page<MenuEntity> page = menuService.queryAll(null, PageRequest.of(0, 1000));
				menuList = page.getContent();
			} else {
				menuList = menuService.queryByUserId(userEntity.getId());
			}
			
			for(MenuEntity r : menuList) {
				auths.add(new SimpleGrantedAuthority(r.getMenuFlag()));
			}

			WebUserDetails user = new WebUserDetails(userEntity, auths);
			return user;
		}
		else {
			throw new BadCredentialsException("该用户不存在");
		}
	}
}
