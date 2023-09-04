package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.ApiEndpoint;
import com.example.demo.entity.Incident;
import com.example.demo.service.IncidentService;

@RestController
public class IncidentController {
	
	@Autowired
	private IncidentService incidentService;

	@PostMapping(value = ApiEndpoint.INCIDENT_CREATE)
	public ResponseEntity<String> createIncident(@RequestBody Incident incident,@PathVariable String empcode) {
		System.out.println("Check incident request data : " + incident);
		System.out.println("Incident Create Operation -----> Start.");
		String incidentNumber = incidentService.createIncident(incident,empcode);
		System.out.println("Incident Create Operation -----> End.");
		return ResponseEntity.ok("Your "+ incidentNumber +" Incident Created Successfully.");
	}
}
