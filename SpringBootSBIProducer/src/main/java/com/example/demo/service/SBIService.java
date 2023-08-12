package com.example.demo.service;

import com.example.demo.model.SBIDetails;

public interface SBIService {

	void addData(SBIDetails sbiDetails);
	
	SBIDetails getSbiDetails(String atmNumber);
}
