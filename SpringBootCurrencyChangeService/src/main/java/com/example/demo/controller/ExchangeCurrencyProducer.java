package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExchangeRequest;

@RestController
public class ExchangeCurrencyProducer {

	@GetMapping(value = "/{from}/{amount}/{to}")
	public ResponseEntity<ExchangeRequest> produceCurrencyChangeFromTO(@PathVariable("from") String from,
																	   @PathVariable("amount") double amount,
			                                                           @PathVariable("to") String to){
		
		ExchangeRequest exchangeRequest = new ExchangeRequest();
		
		exchangeRequest.setFrom("IND");
		exchangeRequest.setTo("USD");
		exchangeRequest.setId(1234);
		exchangeRequest.setExchangeRate(0.012f);
		double calculatedAmount = amount* exchangeRequest.getExchangeRate();
		exchangeRequest.setExchangeAmount(calculatedAmount);
		
		
		return new ResponseEntity<ExchangeRequest>(exchangeRequest,HttpStatus.OK);
	}
}
