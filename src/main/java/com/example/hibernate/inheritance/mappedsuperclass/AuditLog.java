/**
 * 
 */
package com.example.hibernate.inheritance.mappedsuperclass;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author amit patil
 * Class created to demonstrate MappedSuperClass functionality
 *
 */

/**
 * Since MappedSuperClass are not persistent so, there is no good reason to keep
 * them as concrete class. So, mapped super class should be always abstract
 * class since there state most of the time is dependent on subclass.
 **/

@MappedSuperclass
public abstract class AuditLog implements Serializable {

	private static final long serialVersionUID = -6773635364280283302L;

	@Basic
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id")
	private UUID id;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_on")
	private Calendar createdOn;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_on")
	private Calendar updatedOn;

	@Basic
	@Column(name = "is_deleted")
	private boolean isDeleted;

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public Calendar getUpdatedOn() {
		return updatedOn;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(Calendar updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
