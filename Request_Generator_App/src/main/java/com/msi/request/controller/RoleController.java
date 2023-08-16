package com.msi.request.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msi.request.entity.Role;
import com.msi.request.service.ROleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
	
	@Autowired
	private ROleService rOleService;

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Role>> getAllRles(){
		List<Role> rlist = rOleService.getAllRoles();
		return ResponseEntity.ok().body(rlist);
	}
	
	@PostMapping(value = "/assign/{uname}")
	public String assignRole(@RequestBody Role role,@PathVariable String uname) {
		System.out.println("Role Data : " + role + " " + uname);
		rOleService.assignRole(role, uname);
		return "Role successfully assigned.";
	}
}
