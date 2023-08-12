package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;

@RestController
public class EmployeeConsumer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/consume")
	public Employee getEmp() {
	Employee employee =	restTemplate.getForObject("http://localhost:9000/getEmp", Employee.class);
	return employee;
	}

	@GetMapping(value = "/consume1")
	public Employee getEmp1() {
	ResponseEntity<Employee> responseEntity =	restTemplate.getForEntity("http://localhost:9000/getEmp", Employee.class);
	return responseEntity.getBody();
	}
	
	@GetMapping(value = "/consumeAll")
	public List<?> getAllEmp1() {
	@SuppressWarnings("rawtypes")
	ResponseEntity<List> responseEntity =	restTemplate.getForEntity("http://localhost:9000/getAllEmp", List.class);
	return responseEntity.getBody();
	}
}
