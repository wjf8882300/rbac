package com.tongu.rbac.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.tongu.rbac.model.entity.LoginLogEntity;
import com.tongu.rbac.service.LoginLogService;
import com.tongu.rbac.util.IpUtil;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private LoginLogService loginLogService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		// 记录登录日志
		LoginLogEntity loginLogEntity = new LoginLogEntity();
		loginLogEntity.setUserId(((WebUserDetails)authentication.getPrincipal()).getUser().getId());
		loginLogEntity.setIpAddress(IpUtil.getRemoteAddr(request));
		loginLogService.saveLoginLog(loginLogEntity);
		
		// 跳转到首页
		this.redirectStrategy.sendRedirect(request, response, "/index");
	}

}
