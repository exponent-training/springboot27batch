package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.ApiEndpoint;
import com.example.demo.entity.EmployeeMaster;
import com.example.demo.model.EmployeVO;
import com.example.demo.service.EmployeeMasterService;

@RestController
public class EmployeeMasterController {
	
	@Autowired
	private EmployeeMasterService employeeMasterService;
	
	@PostMapping(value = ApiEndpoint.SAVE_EMP_MASTER)
	public String saveEmployeeMasterInfo(@RequestBody EmployeeMaster employeeMaster) {
		System.out.println("Employee Master Save Operation ---> Start.");
		System.out.println("Check Employe Data : " + employeeMaster);
		int i = employeeMasterService.saveEmployeeMasterInfo(employeeMaster);
		if(i > 0) {
		System.out.println("Employee Master Save Operation ---> End.");
		return "Successfully info Saved....!";
		}else {
			System.out.println("Employee Master Save Operation ---> Not Completed.");
			return "Successfully Not info Saved....!";
		}
	}
	
	@GetMapping(value = ApiEndpoint.GET_ALL_EMPNAME)
	public ResponseEntity<List<EmployeVO>> getAllEmployeeNameAndCode(){
		System.out.println("All Employee Name And Code Fetching Operation ---> Start.");
		List<EmployeVO> empVos = employeeMasterService.getEmployeNameAndCode();
		System.out.println("All Employee Name And Code Fetching Operation ---> End.");
		return ResponseEntity.ok(empVos);
	}

}
