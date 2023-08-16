package com.msi.request.service;

import java.util.List;

import com.msi.request.entity.Employee;

public interface EmployeeService {
	
	void saveEmployeeInfo(Employee employee);
	
	List<String> fetchAllUname();

}
