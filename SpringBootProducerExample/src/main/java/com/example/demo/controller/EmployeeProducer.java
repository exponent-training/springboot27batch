package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class EmployeeProducer {

	@GetMapping(value = "/getEmp")
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setId(2);employee.setName("Abc");employee.setAddress("Pune");
		return employee;
	}
	
	@GetMapping(value = "/getAllEmp")
	public List<Employee> getAllEmployee() {
		Employee employee = new Employee();
		employee.setId(2);employee.setName("Abc");employee.setAddress("Pune");
		Employee employee1 = new Employee();
		employee1.setId(2);employee1.setName("Abc");employee1.setAddress("Pune");
		Employee employee2 = new Employee();
		employee2.setId(2);employee2.setName("Abc");employee2.setAddress("Pune");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(employee);list.add(employee1);list.add(employee2);
		return list;
	}
	
}
