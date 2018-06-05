package com.example.hibernate.inheritance.singletablestrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: STSPartTimeEmployee
 *
 */
@Entity
@DiscriminatorValue(value = "STSContractEmployee")
public class STSContractEmployee extends STSEmployee {

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
