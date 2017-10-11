package com.niti.bo;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties
public class UserExperienceBO {

	public UserExperienceBO() {
		user = new UserBO();
		
		if (createdBy == null || createdBy.length() == 0) {
					createdBy = "System";
				}
				
			if (lastUpdatedBy == null || lastUpdatedBy.length() == 0) {
					lastUpdatedBy = "System";
				}
		}
	
	private String accountManager;
	
	private Calendar clientEndDate;
	
	private String clientName;
	
	private Calendar clientStartDate;

	private String jobTitle;
	
	private Integer noOfYears;
	
	private String reportingManager;
	
	@JsonManagedReference
	@JsonIgnore
	private UserBO user;
	
	private Integer userExperienceId;
	
	private String createdBy;

	private String lastUpdatedBy;

	private Calendar createdDate;

	private Calendar lastUpdatedDate;

	
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
	 * @return the user
	 */
	public UserBO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserBO user) {
		this.user = user;
	}

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
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdatedDate
	 */
	public Calendar getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(Calendar lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	
}
