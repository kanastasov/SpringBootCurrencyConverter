package com.currencyConverter.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.currencyConverter.spring.model.CurrencyModel;

public interface CurrencyRepository extends CrudRepository<CurrencyModel, Long> {

}
