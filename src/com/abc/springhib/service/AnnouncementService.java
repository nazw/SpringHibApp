package com.abc.springhib.service;

import java.util.List;

import com.abc.springhib.entity.Announcement;
import com.abc.springhib.entity.SystemUser;

public interface AnnouncementService {
	
	public void saveAnnouncement(Announcement announcement);
	public void deleteAnnouncement(long announcementId); 
	public void updateAnnouncement(Announcement announcement); 
    public Announcement findById(long announcementId);    
    public List<Announcement> findAll();

}
