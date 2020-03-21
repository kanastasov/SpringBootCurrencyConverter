package com.currencyConverter.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "TBL_CURRENCIES")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CurrencyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 10, message = "currency is mandatory")
	@Column(name = "currency_from")
	private String currencyFrom;
	@Size(min = 2, max = 10, message = "currency is mandatory")
	@Column(name = "currency_to")
	private String currencyTo;
	@Column(name = "value")
	private Double value;

	public CurrencyModel() {

	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
