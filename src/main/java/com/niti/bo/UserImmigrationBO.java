package com.niti.bo;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties
public class UserImmigrationBO {

	public UserImmigrationBO() {
			user = new UserBO();
			
			if (createdBy == null || createdBy.length() == 0) {
						createdBy = "System";
					}
					
				if (lastUpdatedBy == null || lastUpdatedBy.length() == 0) {
						lastUpdatedBy = "System";
					}
		}
	
	@JsonManagedReference
	@JsonIgnore
	private UserBO user; 
	
	private Integer userImmigrationId;
	
	private String passportNumber;
	
	private Calendar passportIssueDate;
	
	private Calendar passportExpiryDate;
	
	private String visaTypeCode;
	
	private String visaNumber;
	
	private Calendar visaIssueDate;
	
	private Calendar visaExpiryDate;
	
	private String i9Status;
	
	private Calendar i9ReviewDate;
	
	private String i94Number;
	
	private String createdBy;
	
	private String lastUpdatedBy;
	
	private Calendar createdDate;
	
	private Calendar lastUpdatedDate;

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
	 * @return the userImmigrationId
	 */
	public Integer getUserImmigrationId() {
		return userImmigrationId;
	}

	/**
	 * @param userImmigrationId the userImmigrationId to set
	 */
	public void setUserImmigrationId(Integer userImmigrationId) {
		this.userImmigrationId = userImmigrationId;
	}

	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}

	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	/**
	 * @return the passportIssueDate
	 */
	public Calendar getPassportIssueDate() {
		return passportIssueDate;
	}

	/**
	 * @param passportIssueDate the passportIssueDate to set
	 */
	public void setPassportIssueDate(Calendar passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
	}

	/**
	 * @return the passportExpiryDate
	 */
	public Calendar getPassportExpiryDate() {
		return passportExpiryDate;
	}

	/**
	 * @param passportExpiryDate the passportExpiryDate to set
	 */
	public void setPassportExpiryDate(Calendar passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	/**
	 * @return the visaTypeCode
	 */
	public String getVisaTypeCode() {
		return visaTypeCode;
	}

	/**
	 * @param visaTypeCode the visaTypeCode to set
	 */
	public void setVisaTypeCode(String visaTypeCode) {
		this.visaTypeCode = visaTypeCode;
	}

	/**
	 * @return the visaNumber
	 */
	public String getVisaNumber() {
		return visaNumber;
	}

	/**
	 * @param visaNumber the visaNumber to set
	 */
	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}

	/**
	 * @return the visaIssueDate
	 */
	public Calendar getVisaIssueDate() {
		return visaIssueDate;
	}

	/**
	 * @param visaIssueDate the visaIssueDate to set
	 */
	public void setVisaIssueDate(Calendar visaIssueDate) {
		this.visaIssueDate = visaIssueDate;
	}

	/**
	 * @return the visaExpiryDate
	 */
	public Calendar getVisaExpiryDate() {
		return visaExpiryDate;
	}

	/**
	 * @param visaExpiryDate the visaExpiryDate to set
	 */
	public void setVisaExpiryDate(Calendar visaExpiryDate) {
		this.visaExpiryDate = visaExpiryDate;
	}

	/**
	 * @return the i9Status
	 */
	public String getI9Status() {
		return i9Status;
	}

	/**
	 * @param i9Status the i9Status to set
	 */
	public void setI9Status(String i9Status) {
		this.i9Status = i9Status;
	}

	/**
	 * @return the i9ReviewDate
	 */
	public Calendar getI9ReviewDate() {
		return i9ReviewDate;
	}

	/**
	 * @param i9ReviewDate the i9ReviewDate to set
	 */
	public void setI9ReviewDate(Calendar i9ReviewDate) {
		this.i9ReviewDate = i9ReviewDate;
	}

	/**
	 * @return the i94Number
	 */
	public String getI94Number() {
		return i94Number;
	}

	/**
	 * @param i94Number the i94Number to set
	 */
	public void setI94Number(String i94Number) {
		this.i94Number = i94Number;
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
