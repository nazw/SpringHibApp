package com.abc.springhib.dao;

import java.util.List;

import com.abc.springhib.entity.SystemUser;

public interface SystemUserDAO {
	
	public void saveSystemUser(SystemUser systemUser);
	public void deleteSystemUser(SystemUser systemUser); 
	public void updateSystemUser(SystemUser systemUser); 
    public SystemUser findById(long systemUserId);    
    public List<SystemUser> findAll();
    public SystemUser findByUserName(String userName);
    public SystemUser findByUserNameAndPassword(String userName, String password);

}
