package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.ApiEndpoint;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping(value = ApiEndpoint.GET_ALL_ROLE)
	public ResponseEntity<List<Role>> getAllRoles() {
		System.out.println("Get All Role Operation ---> Start.");
		List<Role> roles = roleService.getAllRole();
		System.out.println("Get All Role Operation ---> End.");
		return ResponseEntity.ok(roles);
	}
	
	@PostMapping(value = ApiEndpoint.ASSIGN_ROLE_EMP)
	public ResponseEntity<String> assignRoleForPerticularEmployee(@PathVariable String empcode,@RequestBody Role role){
		System.out.println("Assign Role Operation ---> Start.");
		System.out.println("Employee Code : " + empcode + " Role Data : " + role);
		int i = roleService.assignRoleToEmployee(empcode, role);
		if(i > 0) {
		  return ResponseEntity.ok("Role Assign Successfully.");
		}
		return ResponseEntity.ok("Role Not Assign Successfully.");
		
	}
}
