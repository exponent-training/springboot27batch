package com.msi.request.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msi.request.entity.Employee;
import com.msi.request.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployeeInfo(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("In Service Layer : " + employee);
		Employee employee2 = employeeRepository.save(employee);
		if(employee2 != null) {
			//mail sending code write here.
		}
	}

	@Override
	public List<String> fetchAllUname() {
		// TODO Auto-generated method stub
		List<String> unamelist = new ArrayList<String>();
		List<Employee> empList = employeeRepository.findAll();
		for (Employee employee : empList) {
			unamelist.add(employee.getUname());
		}
		return unamelist;
	}

}
