package com.niti.dao.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.niti.constants.Ethnicity;
import com.niti.constants.Gender;
import com.niti.constants.MaritalStatus;
import com.niti.entity.converter.EthnicityConverter;
import com.niti.entity.converter.GenderConverter;
import com.niti.entity.converter.MaritalStatusConverter;



@Entity
@Table(name="user")
public class UserEntity implements Serializable {

	public UserEntity() {
		
	}
	/**
	 * generated serial version uid
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user", fetch=FetchType.LAZY)
	private List<UserDependentEntity> UserDependents;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user", fetch=FetchType.LAZY)
	private List<UserExperienceEntity> userExperiences;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user", fetch=FetchType.LAZY )
	private List<UserImmigrationEntity> userImmigrations;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="PREFIX")
	private String prefix;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="USER_NUMBER")
	private String userNumber;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name="P_CONTACT_NBR")
	private String primaryContactNumber;
	
	@Column(name="S_CONTACT_NBR")
	private String secondaryContactNumber;
	
	@Column(name="EMP_CODE")
	private String employeeCode;
	
	@Column(name="SALARY")
	private Integer salary;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="START_DATE")
	private Calendar startDate;
	
	@Column(name="END_DATE")
	private Calendar endDate;
	
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

	@Column(name="ISACTIVE", nullable=false, columnDefinition="TINYINT(1)")
	private boolean isActive;

	@Column(name="ISADMIN", nullable=false, columnDefinition="TINYINT(1)")
	private boolean isAdmin;

	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="CONFIRM_PASSWORD")
	private String confirmPassword;

	
	@Column(name="GENDER")
	@Convert(converter=GenderConverter.class)
	private Gender gender;
	
	@Column(name="MARITAL_STATUS")
	@Convert(converter=MaritalStatusConverter.class)
	private MaritalStatus maritalStatus;
	
	@Column(name="ETHNIC_CODE")
	@Convert(converter=EthnicityConverter.class)
	private Ethnicity ethnicity;

	@Column(name="NATIONALITY")
	private String nationality;

	@Column(name="DOB")
	private Calendar dateOfBirth;

	@Column(name="BLOOD_GROUP")
	private String bloodGroup;

	@Column(name="DRIVING_LICENSE")
	private String drivingLicense;
	
	@Column(name="DRIVING_LICENSE_EXPIRY")
	private Calendar drivingLicenseExpiry;
	
	
		
	
	
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the userNumber
	 */
	public String getUserNumber() {
		return userNumber;
	}

	/**
	 * @param userNumber the userNumber to set
	 */
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the primaryContactNumber
	 */
	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	/**
	 * @param primaryContactNumber the primaryContactNumber to set
	 */
	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	/**
	 * @return the secondarayContactNumber
	 */
	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}

	/**
	 * @param SecondaryContactNumber the SecondaryContactNumber to set
	 */
	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
	}

	/**
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * @return the salary
	 */
	public Integer getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public List<UserExperienceEntity> getUserExperiences() {
		return userExperiences;
	}

	public void setUserExperiences(List<UserExperienceEntity> userExperiences) {
		this.userExperiences = userExperiences;
	}

	/**
	 * @return the userImmigrations
	 */
	public List<UserImmigrationEntity> getUserImmigrations() {
		return userImmigrations;
	}

	/**
	 * @param userImmigrations the userImmigrations to set
	 */
	public void setUserImmigrations(List<UserImmigrationEntity> userImmigrations) {
		this.userImmigrations = userImmigrations;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [userExperiences=" + userExperiences + ", userId=" + userId + ", prefix=" + prefix
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", userNumber="
				+ userNumber + ", emailAddress=" + emailAddress + ", primaryContactNumber=" + primaryContactNumber
				+ ", secondarayContactNumber=" + secondaryContactNumber + ", employeeCode=" + employeeCode
				+ ", salary=" + salary + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
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

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the maritalStatus
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the ethnicity
	 */
	public Ethnicity getEthnicity() {
		return ethnicity;
	}

	/**
	 * @param ethnicity the ethnicity to set
	 */
	public void setEthnicity(Ethnicity ethnicity) {
		this.ethnicity = ethnicity;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * @return the drivingLicense
	 */
	public String getDrivingLicense() {
		return drivingLicense;
	}

	/**
	 * @param drivingLicense the drivingLicense to set
	 */
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	/**
	 * @return the drivingLicenseExpiry
	 */
	public Calendar getDrivingLicenseExpiry() {
		return drivingLicenseExpiry;
	}

	/**
	 * @param drivingLicenseExpiry the drivingLicenseExpiry to set
	 */
	public void setDrivingLicenseExpiry(Calendar drivingLicenseExpiry) {
		this.drivingLicenseExpiry = drivingLicenseExpiry;
	}

	
	
}
