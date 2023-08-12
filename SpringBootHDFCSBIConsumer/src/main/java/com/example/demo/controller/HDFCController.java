package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SBIDetails;
import com.example.demo.service.HDFCservice;

@RestController
public class HDFCController {
	
	@Autowired
	private HDFCservice hdfcService;

	@GetMapping(value = "/findDetails/{atmCardNumber}")
	public SBIDetails getData(@PathVariable("atmCardNumber") String atmCardNumber) {
		SBIDetails sbiDetails = hdfcService.getData(atmCardNumber);
		return sbiDetails;
	}
}
