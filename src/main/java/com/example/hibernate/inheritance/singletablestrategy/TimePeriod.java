package com.example.hibernate.inheritance.singletablestrategy;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Access(AccessType.FIELD)
public class TimePeriod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "period_value")
	private Integer periodValue;

	@Basic
	@Enumerated(EnumType.STRING)
	@Column(name = "period_type")
	private TimePeriodType periodType;

	public Integer getPeriodValue() {
		return periodValue;
	}

	public void setPeriodValue(Integer periodValue) {
		this.periodValue = periodValue;
	}

	public TimePeriodType getPeriodType() {
		return periodType;
	}

	public void setPeriodType(TimePeriodType periodType) {
		this.periodType = periodType;
	}

	public TimePeriod(Integer periodValue, TimePeriodType periodType) {
		this.periodValue = periodValue;
		this.periodType = periodType;
	}

	public TimePeriod() {
		// Nothing to do here
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((periodType == null) ? 0 : periodType.hashCode());
		result = prime * result + ((periodValue == null) ? 0 : periodValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimePeriod other = (TimePeriod) obj;
		if (periodType != other.periodType)
			return false;
		if (periodValue == null) {
			if (other.periodValue != null)
				return false;
		} else if (!periodValue.equals(other.periodValue))
			return false;
		return true;
	}

}
