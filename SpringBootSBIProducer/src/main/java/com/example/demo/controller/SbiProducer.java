package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SBIDetails;
import com.example.demo.service.SBIService;

@RestController
public class SbiProducer {
	
	@Autowired
	private SBIService sBIService;

	@PostMapping(value = "/addData")
	public String addSbiUserData(@RequestBody SBIDetails sbiDetails) {
		sBIService.addData(sbiDetails);
		return "Data Added...!";
	}
	
	@GetMapping(value = "/get/{atmCardNumber}")
	public SBIDetails getDataUsingAtmNumber(@PathVariable("atmCardNumber") String atmCardNumber) {
		SBIDetails sbiDetails = sBIService.getSbiDetails(atmCardNumber);
		return sbiDetails;
	}
}
