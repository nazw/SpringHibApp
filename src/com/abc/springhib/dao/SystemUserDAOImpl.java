package com.abc.springhib.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.springhib.entity.SystemUser;

@Repository("systemUserDAO")
public class SystemUserDAOImpl implements SystemUserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSystemUser(SystemUser systemUser) {
		sessionFactory.getCurrentSession().save(systemUser);		
	}

	@Override
	public void deleteSystemUser(SystemUser systemUser) {
		sessionFactory.getCurrentSession().delete(systemUser);
		
	}

	@Override
	public void updateSystemUser(SystemUser systemUser) {
		sessionFactory.getCurrentSession().update(systemUser);
		
	}

	@Override
	public SystemUser findById(long systemUserId) {
		return (SystemUser)sessionFactory.getCurrentSession().get(SystemUser.class, systemUserId);		
	}

	@Override
	public List<SystemUser> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(SystemUser.class).list();		
	}
	
	@Override
	public SystemUser findByUserName(String userName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SystemUser.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (SystemUser) criteria.uniqueResult();		
	}
	
	@Override
	public SystemUser findByUserNameAndPassword(String userName, String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SystemUser.class);
		criteria.add(Restrictions.conjunction()
		.add(Restrictions.eq("userName", userName))
		.add(Restrictions.eq("password", password)));
		return (SystemUser) criteria.uniqueResult();		
	}
}
