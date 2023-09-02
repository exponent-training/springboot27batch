package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.model.EmployeVO;
import com.example.demo.repo.EmployeeMasterRepository;

@Service
public class EmployeeMasterServiceImpl implements EmployeeMasterService{

	@Autowired
	private EmployeeMasterRepository employeeMasterRepository;
	
	@Override
	public int saveEmployeeMasterInfo(EmployeeMaster employeeMaster) {
		// TODO Auto-generated method stub
		System.out.println("Employee Master Info Storing in DB Operation ----> Start.");
		if(employeeMaster != null) { 
		EmployeeMaster employeeMaster2 = employeeMasterRepository.save(employeeMaster);
		return employeeMaster2.getId();
		}
		return 0;
	}

	@Override
	public List<EmployeVO> getEmployeNameAndCode() {
		// TODO Auto-generated method stub
		List<EmployeVO> empVo = new ArrayList<EmployeVO>();
		List<EmployeeMaster> empMaster = employeeMasterRepository.findAll();
		for (EmployeeMaster employeeMaster : empMaster) {
			EmployeVO employeVO = new EmployeVO();
			employeVO.setEmpcode(employeeMaster.getEmployeeid());
			employeVO.setEmpname(employeeMaster.getEmployeename());
			empVo.add(employeVO);
		}
		return empVo;
	}

}
