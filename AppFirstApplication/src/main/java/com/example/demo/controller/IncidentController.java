package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value = ApiEndpoint.GET_NEW_INCIDENT)
	public ResponseEntity<List<Incident>> getIncidentStatusAsNew(@PathVariable String status) {
		System.out.println("Check Status : "  + status);
		List<Incident> list = incidentService.getAllIncidentStatusAsNew(status);
		return ResponseEntity.ok(list);
	}
	
	@PutMapping(value = ApiEndpoint.ASSIGNED_TO)
	public ResponseEntity<String> incidentAssignedTo(@RequestBody Incident incident,@PathVariable String empCode) {
		System.out.println("Assigned To Incident : " +  incident);
		String str = incidentService.incidentAssignedTo(incident,empCode);
		return ResponseEntity.ok("Incident Assigned To "+ str);
	}
}
