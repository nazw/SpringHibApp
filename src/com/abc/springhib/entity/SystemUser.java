package com.abc.springhib.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.EnumType;
import com.abc.springhib.util.AccountStatus;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;



@Entity(name="systemUser")
@Table(name="system_user" , uniqueConstraints = @UniqueConstraint(columnNames = { "user_name" }))
public class SystemUser implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;  
    private Set<Announcement> Announcements;
    private AccountStatus accountStatus;
    private int versionId;
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="account_status")
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	@Version
	@Column(name="version_id")
	public int getVersionId() {
		return versionId;
	}
	
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	@OneToMany(mappedBy="systemUser" , fetch=FetchType.LAZY)
	public Set<Announcement> getAnnouncements() {
		return Announcements;
	}
	
	public void setAnnouncements(Set<Announcement> announcements) {
		Announcements = announcements;
	}

}
