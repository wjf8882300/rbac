package com.tongu.rbac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tongu.rbac.model.entity.LoginLogEntity;
import com.tongu.rbac.model.vo.ResultVo;
import com.tongu.rbac.repository.LoginLogRepository;
import com.tongu.rbac.service.LoginLogService;

@Service("@loginLogService")
public class LoginLogServiceImpl implements LoginLogService {

	@Autowired
	private LoginLogRepository loginLogRepository;
	
	@Transactional(readOnly = false)
	@Override
	public ResultVo saveLoginLog(LoginLogEntity loginLogEntity) {
		loginLogEntity.setBasicModelProperty(loginLogEntity.getUserId(), true);
		loginLogRepository.save(loginLogEntity);
		return new ResultVo(true);
	}

}
