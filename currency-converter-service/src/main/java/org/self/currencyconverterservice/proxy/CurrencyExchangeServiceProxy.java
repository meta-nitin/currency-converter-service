package org.self.currencyconverterservice.proxy;

import org.self.currencyconverterservice.pojo.CurrencyConverter;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currencyExchange/{from}-to-{to}")
	@GetMapping("/currency-exchange-service/currencyExchange/{from}-to-{to}")
	public CurrencyConverter getExchangeValue(@PathVariable String from, @PathVariable String to);
}
