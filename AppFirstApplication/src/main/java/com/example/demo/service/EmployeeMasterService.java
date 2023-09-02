package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.model.EmployeVO;

public interface EmployeeMasterService {
	
	int saveEmployeeMasterInfo(EmployeeMaster employeeMaster);
	
	List<EmployeVO> getEmployeNameAndCode();

}
