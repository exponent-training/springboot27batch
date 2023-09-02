package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;

public interface RoleService {
	
	List<Role> getAllRole();
	
	int assignRoleToEmployee(String empcode,Role role);

}
