package com.currencyConverter.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currencyConverter.spring.model.CurrencyModel;
import com.currencyConverter.spring.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepo;

	public List<CurrencyModel> getAllCurencies() {
		List<CurrencyModel> result = (List<CurrencyModel>) currencyRepo.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<CurrencyModel>();
		}

	}

	public CurrencyModel getCurrencyById(Long id) throws Exception {
		Optional<CurrencyModel> currency = currencyRepo.findById(id);

		if (currency.isPresent()) {
			return currency.get();
		} else {
			System.out.println("No currency record");
			throw new Exception("");
		}
	}

	public CurrencyModel createOrUpdateCurrency(CurrencyModel currency) {
		if (currency.getId() == null) {
			currency = currencyRepo.save(currency);

			return currency;
		} else {
			Optional<CurrencyModel> currencyModel = currencyRepo.findById(currency.getId());

			if (currencyModel.isPresent()) {
				CurrencyModel newCurrency = currencyModel.get();
				newCurrency.setCurrencyFrom(currency.getCurrencyFrom());
				newCurrency.setCurrencyTo(currency.getCurrencyTo());
				newCurrency.setValue(currency.getValue());

				newCurrency = currencyRepo.save(newCurrency);

				return newCurrency;
			} else {
				currency = currencyRepo.save(currency);

				return currency;
			}
		}
	}

	public void deleteCurrencyById(Long id) {
		Optional<CurrencyModel> currency = currencyRepo.findById(id);

		if (currency.isPresent()) {
			currencyRepo.deleteById(id);
		} else {
			System.out.println("No Currency");
		}
	}
}
