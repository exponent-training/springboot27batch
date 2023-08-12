package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.SBIDetails;

@Service
public class HDFCServiceImpl implements HDFCservice{

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public SBIDetails getData(String atmCardNumber) {
		// TODO Auto-generated method stub
		
		SBIDetails sbiDetails = restTemplate.getForObject("http://localhost:9000/get/"+atmCardNumber, SBIDetails.class);
		
		return sbiDetails;
	}

}
