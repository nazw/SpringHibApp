package com.abc.springhib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abc.springhib.dao.SystemUserDAO;
import com.abc.springhib.entity.SystemUser;
import com.abc.springhib.util.AccountStatus;


@Service("systemUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SystemUserServiceImpl implements SystemUserService{

	
	@Autowired
	private SystemUserDAO systemUserDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveSystemUser(SystemUser systemUser) {
		systemUser.setAccountStatus(AccountStatus.ACTIVE);		
		systemUserDAO.saveSystemUser(systemUser);		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SystemUser findByUserName(String userName) {
		return systemUserDAO.findByUserName(userName);
	}

	@Override
	public SystemUser findByUserNameAndPassword(String userName, String password) {
		return systemUserDAO.findByUserNameAndPassword(userName, password);
	}
	
}
