package com.tongu.rbac.service;

import com.tongu.rbac.model.entity.LoginLogEntity;
import com.tongu.rbac.model.vo.ResultVo;

public interface LoginLogService {

	/**
	 * 保存系统日志
	 * 
	 * @param params
	 * @return
	 */
	public ResultVo saveLoginLog(LoginLogEntity loginLogEntity);
}
