package com.niti.dao.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import com.niti.constants.Relation;

@Entity
@Table(name="USER_DEPENDENTS")
public class UserDependentEntity implements Serializable {

	public UserDependentEntity() {
		
	}
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(nullable=false, name="user_id")
	private UserEntity user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_DEPENDENT_ID")
	private Integer userDependentId;

	@Column(name="NAME")
	private String name;

	@Column(name="DOB")
	private Calendar dob;
	
	@Column(name="RELATION")
	@Enumerated(EnumType.STRING)
	private Relation relation;
	
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
	
	

}
