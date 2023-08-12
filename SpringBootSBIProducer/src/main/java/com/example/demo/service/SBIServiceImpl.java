package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SBIDetails;


@Service
public class SBIServiceImpl implements SBIService{

	@Autowired
	private SBIRepository sBIRepository;
	
	@Override
	public void addData(SBIDetails sbiDetails) {
		// TODO Auto-generated method stub
		sBIRepository.save(sbiDetails);
	}

	@Override
	public SBIDetails getSbiDetails(String atmNumber) {
		// TODO Auto-generated method stub
		SBIDetails sbiDetails = sBIRepository.findByAtmCardNumber(atmNumber);
				
		return sbiDetails;
	}

}
