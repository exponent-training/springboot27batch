package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Incident;

public interface IncidentService {

	String createIncident(Incident incident,String empcode);
	
	List<Incident> getAllIncidentStatusAsNew(String status);
	
	String incidentAssignedTo(Incident incident,String empCode);
}
