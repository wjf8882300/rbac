package com.tongu.rbac.service;

import com.tongu.rbac.model.entity.LoginLogEntity;

public interface LoginLogService {

	/**
	 * 保存系统日志
	 * 
	 * @param params
	 * @return
	 */
	public void saveLoginLog(LoginLogEntity loginLogEntity);
}
