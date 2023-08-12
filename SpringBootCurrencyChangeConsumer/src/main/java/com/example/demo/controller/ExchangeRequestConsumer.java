package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ExchangeRequest;

@RestController
public class ExchangeRequestConsumer {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/{from}/{amount}/{to}")
	public ResponseEntity<ExchangeRequest> getCurrencyChange(@PathVariable("from") String from,
			   												 @PathVariable("amount") double amount,
			   												 @PathVariable("to") String to){
		ResponseEntity<ExchangeRequest>  exchangeRequest = restTemplate.getForEntity("http://localhost:8080/"+from+"/"+amount+"/"+to, ExchangeRequest.class);
		
		return exchangeRequest;
	}
	
}
