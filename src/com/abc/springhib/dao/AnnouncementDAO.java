package com.abc.springhib.dao;

import java.util.List;

import com.abc.springhib.entity.Announcement;
import com.abc.springhib.entity.SystemUser;

public interface AnnouncementDAO {

	public void saveAnnouncement(Announcement announcement);
	public void deleteAnnouncement(Announcement announcement); 
	public void updateAnnouncement(Announcement announcement); 
    public Announcement findById(long announcementId);    
    public List<Announcement> findAll();
}
