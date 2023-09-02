package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.entity.Role;
import com.example.demo.repo.EmployeeMasterRepository;
import com.example.demo.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmployeeMasterRepository employeeMasterRepository;
	
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public int assignRoleToEmployee(String empcode, Role role) {
		// TODO Auto-generated method stub
		EmployeeMaster employeeMaster = employeeMasterRepository.findByEmployeeid(empcode);
		if(!ObjectUtils.isEmpty(employeeMaster)) {
			employeeMaster.setRole(role);
			employeeMasterRepository.save(employeeMaster);
			return 1;
		}
		return 0;
	}

}
