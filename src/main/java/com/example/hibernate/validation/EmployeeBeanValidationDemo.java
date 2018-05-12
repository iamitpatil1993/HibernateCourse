package com.example.hibernate.validation;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: EmployeeBeanValidationDemo
 *
 */
@Entity
@Table(name = "employee_bean_validation_demo")

public class EmployeeBeanValidationDemo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_bean_validation_demo_id_gen")
	@SequenceGenerator(name = "employee_bean_validation_demo_id_gen", sequenceName = "employee_bean_validation_demo_id_gen")
	@Column(name = "employee_id")
	private Long employeeId;

	@Basic
	@NotNull
	@Size(max = 100, min = 2)
	@Column(name = "first_name")
	private String firstName;

	@Basic
	@NotNull
	@Size(max = 100, min = 2)
	@Column(name = "last_name")
	private String lastName;

	@Basic
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Calendar dob;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

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

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

}
