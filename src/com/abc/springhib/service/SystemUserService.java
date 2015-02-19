package com.abc.springhib.service;

import com.abc.springhib.entity.SystemUser;

public interface SystemUserService {

	public void saveSystemUser(SystemUser systemUser);
	public SystemUser findByUserName(String userName);
	public SystemUser findByUserNameAndPassword(String userName, String password);
}
