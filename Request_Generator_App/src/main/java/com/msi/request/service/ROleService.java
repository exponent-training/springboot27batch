package com.msi.request.service;

import java.util.List;

import com.msi.request.entity.Role;

public interface ROleService {

	List<Role> getAllRoles();
	
	void assignRole(Role role,String uname);
}
