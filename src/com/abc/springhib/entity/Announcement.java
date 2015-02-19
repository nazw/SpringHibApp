package com.abc.springhib.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.abc.springhib.util.AccountStatus;
import com.abc.springhib.util.AnnouncementCategory;
import com.abc.springhib.util.AnnouncementType;
import org.springframework.format.annotation.DateTimeFormat;



@Entity(name="announcement")
@Table(name="announcement")
public class Announcement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long announcementId;
	private String announcementTitle;
	private String announcementBody;
	private SystemUser systemUser;
	private Date createdDate;
	private Date expiryDate;
	private AccountStatus accountStatus;
	private AnnouncementCategory announcementCategory;
	private AnnouncementType announcementType;
	private int versionId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "announcement_id")
	public long getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(long announcementId) {
		this.announcementId = announcementId;
	}
	
	@Column(name="announcement_title")
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	
	@Column(name="announcement_body")
	public String getAnnouncementBody() {
		return announcementBody;
	}
	public void setAnnouncementBody(String announcementBody) {
		this.announcementBody = announcementBody;
	}
	
	@ManyToOne
    @JoinColumn(name="user_id")
	public SystemUser getSystemUser() {
		return systemUser;
	}
	
	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}
	
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	

	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiry_date")
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="account_status")
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="announcement_category")
	public AnnouncementCategory getAnnouncementCategory() {
		return announcementCategory;
	}
	
	public void setAnnouncementCategory(AnnouncementCategory announcementCategory) {
		this.announcementCategory = announcementCategory;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="announcement_type")
	public AnnouncementType getAnnouncementType() {
		return announcementType;
	}
	
	public void setAnnouncementType(AnnouncementType announcementType) {
		this.announcementType = announcementType;
	}
	
	@Version
	@Column(name="version_id")
	public int getVersionId() {
		return versionId;
	}
	
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}		
}
