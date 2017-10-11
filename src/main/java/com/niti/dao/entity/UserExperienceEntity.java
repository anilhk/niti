package com.niti.dao.entity;


import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Table(name="user_experience")
@Entity
public class UserExperienceEntity implements Serializable{

	public UserExperienceEntity() {
		
	}
	
	private static final long serialVersionUID = -79056019928294042L;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_EXPERIENCE_ID")
	private Integer userExperienceId;
	
	@Column(name="CLIENT_NAME")
	private String clientName;
	
	@Column(name="REPORTING_MANAGER")
	private String reportingManager;
	
	@Column(name="ACCOUNT_MANAGER")
	private String accountManager;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="NO_OF_YEARS")
	private Integer noOfYears;
	
	@Column(name="CLIENT_END_DATE")
	private Calendar clientStartDate;
	
	@Column(name="CLIENT_START_DATE")
	private Calendar clientEndDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Column(name="CREATED_DATE", updatable=false, nullable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar createdDate;
	
	@Column(name="LAST_UPDATED_DATE", nullable=false)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar lastUpdatedDate;

	/**
	 * @return the userExperienceId
	 */
	public Integer getUserExperienceId() {
		return userExperienceId;
	}

	/**
	 * @param userExperienceId the userExperienceId to set
	 */
	public void setUserExperienceId(Integer userExperienceId) {
		this.userExperienceId = userExperienceId;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the reportingManager
	 */
	public String getReportingManager() {
		return reportingManager;
	}

	/**
	 * @param reportingManager the reportingManager to set
	 */
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	/**
	 * @return the accountManager
	 */
	public String getAccountManager() {
		return accountManager;
	}

	/**
	 * @param accountManager the accountManager to set
	 */
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the noOfYears
	 */
	public Integer getNoOfYears() {
		return noOfYears;
	}

	/**
	 * @param noOfYears the noOfYears to set
	 */
	public void setNoOfYears(Integer noOfYears) {
		this.noOfYears = noOfYears;
	}

	/**
	 * @return the clientStartDate
	 */
	public Calendar getClientStartDate() {
		return clientStartDate;
	}

	/**
	 * @param clientStartDate the clientStartDate to set
	 */
	public void setClientStartDate(Calendar clientStartDate) {
		this.clientStartDate = clientStartDate;
	}

	/**
	 * @return the clientEndDate
	 */
	public Calendar getClientEndDate() {
		return clientEndDate;
	}

	/**
	 * @param clientEndDate the clientEndDate to set
	 */
	public void setClientEndDate(Calendar clientEndDate) {
		this.clientEndDate = clientEndDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserExperienceEntity [user=" + user.getUserId() + ", userExperienceId=" + userExperienceId + ", clientName="
				+ clientName + ", reportingManager=" + reportingManager + ", accountManager=" + accountManager
				+ ", jobTitle=" + jobTitle + ", noOfYears=" + noOfYears + ", clientStartDate=" + clientStartDate
				+ ", clientEndDate=" + clientEndDate + "]";
	}
	
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * @return the createdDate
	 */
	public java.util.Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(java.util.Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdatedDate
	 */
	public java.util.Calendar getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(java.util.Calendar lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	
	
}
