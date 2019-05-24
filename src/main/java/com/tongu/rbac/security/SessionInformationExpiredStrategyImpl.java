package com.tongu.rbac.security;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import com.tongu.rbac.util.ResponseUtil;

public class SessionInformationExpiredStrategyImpl implements SessionInformationExpiredStrategy {

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		ResponseUtil.write(event.getResponse(), "你的账号在另一地点被登录");
	}

}
