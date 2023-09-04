package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Incident;
import com.example.demo.entity.IncidentRandomNumberGenrator;
import com.example.demo.repo.IncidentRandomNumberRepository;
import com.example.demo.repo.IncidentRepository;

@Service
public class IncidentServiceImpl implements IncidentService{

	@Autowired
	private IncidentRandomNumberRepository incidentRandomNumberRepository;
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	@Override
	public String createIncident(Incident incident,String empcode) {
		// TODO Auto-generated method stub
		IncidentRandomNumberGenrator incidentRandomNumberGenrator = incidentRandomNumberRepository.findById(1).get();
		incident.setIncidentnumber("INC "+incidentRandomNumberGenrator.getIncidentnumber());
		incident.setCreatedby(empcode);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:sss");
		Date date = new Date(System.currentTimeMillis());
		String createdDate = simpleDateFormat.format(date);
		incident.setCreateddate(createdDate);
		incident.setStatus("New");
		long incidentNewNumber = incidentRandomNumberGenrator.getIncidentnumber()+1;
		incidentRandomNumberGenrator.setIncidentnumber(incidentNewNumber);
		incidentRandomNumberRepository.save(incidentRandomNumberGenrator);
		incidentRepository.save(incident);
		return incident.getIncidentnumber();
	}

}
