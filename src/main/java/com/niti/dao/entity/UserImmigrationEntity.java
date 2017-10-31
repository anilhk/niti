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

@Entity
@Table(name="USER_IMMIGRATION")
public class UserImmigrationEntity implements Serializable {

	/**
	 * 
	 */
	
	public UserImmigrationEntity() {
		
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_IMMIGRATION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userImmigrationId;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity user;
	
	
	@Column(name="PASSPORT_NUMBER")
	private String passportNumber;
	
	@Column(name="PASSPORT_ISSUE_DATE")
	private Calendar passportIssueDate;
	
	@Column(name="PASSPORT_EXPIRY_DATE")
	private Calendar passportExpiryDate;
	
	@Column(name="VISA_TYPE_CODE")
	private String visaTypeCode;
	
	@Column(name="VISA_NUMBER")
	private String visaNumber;
	
	@Column(name="VISA_ISSUE_DATE")
	private Calendar visaIssueDate;
	
	@Column(name="VISA_EXPIRY_DATE")
	private Calendar visaExpiryDate;
	
	@Column(name="I9_STATUS")
	private String i9Status;
	
	@Column(name="I9_REVIEW_DATE")
	private Calendar i9ReviewDate;
	
	@Column(name="I94_NUMBER")
	private String i94Number;
	
	
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
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserImmigrationEntity [userImmigrationId=" + userImmigrationId + ", passportNumber=" + passportNumber
				+ ", passportIssueDate=" + passportIssueDate + ", passportExpiryDate=" + passportExpiryDate
				+ ", visaTypeCode=" + visaTypeCode + ", visaNumber=" + visaNumber + ", visaIssueDate=" + visaIssueDate
				+ ", visaExpiryDate=" + visaExpiryDate + ", i9Status=" + i9Status + ", i9ReviewDate=" + i9ReviewDate
				+ ", i94Number=" + i94Number + ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	
}
