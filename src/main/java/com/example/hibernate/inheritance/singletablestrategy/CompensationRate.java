package com.example.hibernate.inheritance.singletablestrategy;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Access(AccessType.FIELD)
public class CompensationRate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "rate_value")
	private Long rateValue;

	@Basic
	@Enumerated(EnumType.STRING)
	@Column(name = "currency")
	private Currency currency;

	public Long getRateValue() {
		return rateValue;
	}

	public void setRateValue(Long rateValue) {
		this.rateValue = rateValue;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public CompensationRate(Long rateValue, Currency currency) {
		this.rateValue = rateValue;
		this.currency = currency;
	}

	public CompensationRate() {
		// Nothing to do here
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((rateValue == null) ? 0 : rateValue.hashCode());
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
		CompensationRate other = (CompensationRate) obj;
		if (currency != other.currency)
			return false;
		if (rateValue == null) {
			if (other.rateValue != null)
				return false;
		} else if (!rateValue.equals(other.rateValue))
			return false;
		return true;
	}

}
