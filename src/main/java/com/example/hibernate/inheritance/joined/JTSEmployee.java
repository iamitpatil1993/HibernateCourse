package com.example.hibernate.inheritance.joined;

import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

import com.example.hibernate.inheritance.mappedsuperclass.AuditLog;

/**
 * Entity implementation class for Entity: JTSEmployee
 *
 */
@Entity
@Table(name = "jts_employee")
@AttributeOverride(name = "id", column = @Column(name = "emp_id"))
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.STRING)
@Where(clause = "is_deleted = false")
public class JTSEmployee extends AuditLog {

	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "first_name")
	private String firstName;

	@Basic
	@Column(name = "last_name")
	private String lastName;

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Calendar startDate;

	// If you want to define descriminatorColumn as field for querting purpose, you
	// can do, but you must
	// mark it as insertable = false, updatable = false otherwise you will get error
	// at initialization
	@Basic
	@Column(name = "emp_type", insertable = false, updatable = false)
	private String employeeType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

}
