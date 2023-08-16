package com.msi.request.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msi.request.entity.Employee;
import com.msi.request.entity.Role;
import com.msi.request.repo.EmployeeRepository;
import com.msi.request.repo.RoleRepository;

@Service
public class RoleServiceImpl implements ROleService{

	@Autowired
	private RoleRepository roleRepository; 
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		List<Role> rlist = roleRepository.findAll();
		return rlist;
	}

	@Override
	public void assignRole(Role role, String uname) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findByUname(uname);
		if(employee != null) {
		employee.setRole(role);
		employeeRepository.save(employee);
		}
	}

	
}
