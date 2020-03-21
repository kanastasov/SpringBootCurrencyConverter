package com.currencyConverter.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.currencyConverter.spring.model.CurrencyModel;
import com.currencyConverter.spring.repository.CurrencyRepository;
import com.currencyConverter.spring.service.CurrencyService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class CurrencyController {

	@Autowired
	private CurrencyService service;

	@RequestMapping
	public String getAllCurrencies(@Valid @ModelAttribute("currencies") CurrencyModel currencyModel,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "error";
		}

		List<CurrencyModel> currencies = service.getAllCurencies();
		model.addAttribute("currencies", currencies);

		return "CurrencyModel"; // view
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String edingCurrencyById(Model model, @PathVariable("id") Optional<Long> id) throws Exception {
		if (id.isPresent()) {
			CurrencyModel currency = service.getCurrencyById(id.get());
			model.addAttribute("currencies", currency);

		} else {
			model.addAttribute("currencies", new CurrencyModel());
		}
		return "AddCurrency"; // view

	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteCurrencyById(Model model, @PathVariable("id") Long id) {
		service.deleteCurrencyById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createCurrency", method = RequestMethod.POST)
	public String createOrUpdateCurrencye(CurrencyModel curency) {
		service.createOrUpdateCurrency(curency);
		return "redirect:/";
	}
}
