package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Incident;
import com.example.demo.entity.IncidentRandomNumberGenrator;
import com.example.demo.repo.IncidentRandomNumberRepository;
import com.example.demo.repo.IncidentRepository;
import com.example.demo.utility.EmailSending;

@Service
public class IncidentServiceImpl implements IncidentService{

	@Autowired
	private IncidentRandomNumberRepository incidentRandomNumberRepository;
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	@Autowired
	private EmailSending emailSending;
	
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
		Incident incident2 = incidentRepository.save(incident);
		if(incident2 != null) {
			emailSending.incidentCreateMailSend(incident2);
		}
		return incident.getIncidentnumber();
	}

	@Override
	public List<Incident> getAllIncidentStatusAsNew(String status) {
		// TODO Auto-generated method stub
		List<Incident> list = incidentRepository.findByStatus(status);
		if(list.size() > 0 ) {
			return list;
		}
		return null;
	}

	@Override
	public String incidentAssignedTo(Incident incident,String empCode) {
		// TODO Auto-generated method stub
		incident.setStatus("Pending");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:sss");
		Date date = new Date(System.currentTimeMillis());
		String updatedDate = simpleDateFormat.format(date);
		incident.setUpdateddate(updatedDate);
		incident.setUpdatedby(empCode);
		incidentRepository.save(incident);
		return incident.getAssignedto();
	}

}
