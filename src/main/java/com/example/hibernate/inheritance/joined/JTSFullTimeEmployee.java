package com.example.hibernate.inheritance.joined;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: JTSFullTimeEmployee
 *
 */
@Entity
@Table(name = "jts_full_time_employee")
@Where(clause = "is_deleted = false")
@DiscriminatorValue(value = "JTSFullTimeEmployee")
public class JTSFullTimeEmployee extends JTSEmployee {

	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "vacation")
	private Long vacation;

	@Basic
	@Column(name = "salary")
	private Long salary;

	@Basic
	@Column(name = "pension")
	private Long pension;

	public Long getVacation() {
		return vacation;
	}

	public void setVacation(Long vacation) {
		this.vacation = vacation;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getPension() {
		return pension;
	}

	public void setPension(Long pension) {
		this.pension = pension;
	}

}
