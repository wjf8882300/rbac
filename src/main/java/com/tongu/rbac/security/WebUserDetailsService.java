package com.tongu.rbac.security;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.tongu.rbac.constant.StatusEnum;
import com.tongu.rbac.model.entity.RoleEntity;
import com.tongu.rbac.model.entity.UserEntity;
import com.tongu.rbac.service.RoleService;
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
	private RoleService roleService;

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
			List<RoleEntity> roleList = roleService.queryByUserId(userEntity.getId());
			for(RoleEntity r : roleList) {
				auths.add(new SimpleGrantedAuthority(r.getRoleKey()));
			}

			WebUserDetails user = new WebUserDetails(userEntity, auths);
			return user;
		}
		else {
			throw new BadCredentialsException("该用户不存在");
		}
	}
}
