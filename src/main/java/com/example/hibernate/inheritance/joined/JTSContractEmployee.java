package com.example.hibernate.inheritance.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.example.hibernate.inheritance.singletablestrategy.CompensationRate;
import com.example.hibernate.inheritance.singletablestrategy.TimePeriod;

/**
 * Entity implementation class for Entity: JTSContractEmployee
 *
 */
@Entity
@Table(name = "jts_contract_employee")
@DiscriminatorValue(value = "JTSContractEmployee")
@Where(clause = "is_deleted = false")
public class JTSContractEmployee extends JTSEmployee {

	private static final long serialVersionUID = 1L;

	@Embedded
	private CompensationRate dailyRate;

	@Embedded
	private TimePeriod term;

	public CompensationRate getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(CompensationRate dailyRate) {
		this.dailyRate = dailyRate;
	}

	public TimePeriod getTerm() {
		return term;
	}

	public void setTerm(TimePeriod term) {
		this.term = term;
	}
}
