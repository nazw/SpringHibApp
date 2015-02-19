package com.abc.springhib.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abc.springhib.dao.AnnouncementDAO;
import com.abc.springhib.entity.Announcement;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService{
	
	@Autowired
	private AnnouncementDAO announcementDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveAnnouncement(Announcement announcement) {		
		announcementDAO.saveAnnouncement(announcement);		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAnnouncement(long announcementId) {
		Announcement announcement = announcementDAO.findById(announcementId);
		announcementDAO.deleteAnnouncement(announcement);		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateAnnouncement(Announcement announcement) {
		Announcement announcementObj = announcementDAO.findById(announcement.getAnnouncementId());
		announcementObj.setAccountStatus(announcement.getAccountStatus());
		announcementObj.setAnnouncementBody(announcement.getAnnouncementBody());
		announcementObj.setAnnouncementCategory(announcement.getAnnouncementCategory());
		announcementObj.setAnnouncementTitle(announcement.getAnnouncementTitle());
		announcementObj.setAnnouncementType(announcement.getAnnouncementType());
		announcementObj.setExpiryDate(announcement.getExpiryDate());		
		announcementDAO.updateAnnouncement(announcementObj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Announcement findById(long announcementId) {
		return announcementDAO.findById(announcementId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> findAll() {
		return announcementDAO.findAll();
	}

}
