package com.example.hibernate.model;

import java.io.Serializable;
import java.util.Calendar;

public class Employee implements Serializable {

	private static final long serialVersionUID = 4729314706814030365L;
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private Calendar dob;
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
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
