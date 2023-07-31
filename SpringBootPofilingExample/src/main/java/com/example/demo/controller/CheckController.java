package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
	
	@Value("${my.app}")
	private String myapp;
	
	@RequestMapping(value = "/get",produces = "application/json")
	public String getData() { 
		
		return myapp;
	}

}
