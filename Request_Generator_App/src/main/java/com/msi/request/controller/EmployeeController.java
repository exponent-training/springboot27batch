package com.msi.request.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msi.request.entity.Employee;
import com.msi.request.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> saveEmployeeData(@RequestBody Employee employee) {
		System.out.println("Regsitered Data : " + employee);
		employeeService.saveEmployeeInfo(employee);
		return ResponseEntity.ok().body("Employee Successfully Saved.");
		
	}

	@GetMapping(value = "/getAlluname")
    public ResponseEntity<List<String>> fetchAllUname(){
		List<String> unamelist = employeeService.fetchAllUname();
		return ResponseEntity.ok(unamelist);
	}
}
