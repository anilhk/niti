package com.niti.bo;

import java.util.Calendar;
import com.niti.constants.Relation;

public class UserDependentBO {

	public UserDependentBO() {
		
		user = new UserBO();
		
		if (createdBy == null || createdBy.length() == 0) {
					createdBy = "System";
				}
				
			if (lastUpdatedBy == null || lastUpdatedBy.length() == 0) {
					lastUpdatedBy = "System";
				}
		
	}
	
	private UserBO user;
	
	private Integer userDependentId;

	private String name;

	private Calendar dob;
	
	private Relation relation;
	
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
	 * @return the userDependentId
	 */
	public Integer getUserDependentId() {
		return userDependentId;
	}

	/**
	 * @param userDependentId the userDependentId to set
	 */
	public void setUserDependentId(Integer userDependentId) {
		this.userDependentId = userDependentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dob
	 */
	public Calendar getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	/**
	 * @return the relation
	 */
	public Relation getRelation() {
		return relation;
	}

	/**
	 * @param relation the relation to set
	 */
	public void setRelation(Relation relation) {
		this.relation = relation;
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
