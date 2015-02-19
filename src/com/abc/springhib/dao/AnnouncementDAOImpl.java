package com.abc.springhib.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.springhib.entity.Announcement;
import com.abc.springhib.entity.SystemUser;

@Repository("announcementDAO")
public class AnnouncementDAOImpl implements AnnouncementDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAnnouncement(Announcement announcement) {
		sessionFactory.getCurrentSession().save(announcement);		
	}

	@Override
	public void deleteAnnouncement(Announcement announcement) {
		sessionFactory.getCurrentSession().delete(announcement);		
	}

	@Override
	public void updateAnnouncement(Announcement announcement) {
		sessionFactory.getCurrentSession().update(announcement);		
	}

	@Override
	public Announcement findById(long announcementId) {
		return (Announcement)sessionFactory.getCurrentSession().get(Announcement.class, announcementId);
	}

	@Override
	public List<Announcement> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Announcement.class).list();
	}

}
