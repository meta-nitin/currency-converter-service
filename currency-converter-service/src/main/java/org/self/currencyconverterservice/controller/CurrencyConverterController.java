package org.self.currencyconverterservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.self.currencyconverterservice.pojo.CurrencyConverter;
import org.self.currencyconverterservice.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("currencyConverter")
public class CurrencyConverterController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/{from}-to-{to}/{quantity}")
	public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable Double quantity) {

		Map<String, String> parameters = new HashMap<>();
		parameters.put("from", from);
		parameters.put("to", to);
		ResponseEntity<CurrencyConverter> entity = new RestTemplate().getForEntity(
				"http://localhost:8000/currencyExchange/{from}-to-{to}", CurrencyConverter.class, parameters);
		CurrencyConverter response = entity.getBody();
		response.setQuantity(quantity);
		response.setConvertedAmount(response.getExchangeFactor() * quantity);
		return response;
	}

	/**
	 * Method to convert currency by calling REST currency-exchange-service through
	 * Feign Cleint
	 * 
	 * @param from
	 * @param to
	 * @param quantity
	 * @return
	 */
	@GetMapping("/feign/{from}-to-{to}/{quantity}")
	public CurrencyConverter convertCurrencyUsingFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable Double quantity) {

		logger.debug("Calling REST currency-exchange-service through Feign");
		CurrencyConverter response = proxy.getExchangeValue(from, to);
		logger.debug("Feign call completed successfully");
		response.setQuantity(quantity);
		response.setConvertedAmount(response.getExchangeFactor() * quantity);
		
		logger.info("The response for currency-converter-service is: {}",response.toString());
		return response;
	}

}
