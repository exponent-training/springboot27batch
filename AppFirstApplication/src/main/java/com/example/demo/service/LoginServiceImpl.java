package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.example.demo.entity.EmployeeMaster;
import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.model.UserLogin;
import com.example.demo.repo.EmployeeMasterRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private EmployeeMasterRepository employeeMasterRepository;
	
	@Override
	public UserLogin getLoginData(String uname, String pass) {
		// TODO Auto-generated method stub
		///UserLogin userLogin = new UserLogin();
		try {
		EmployeeMaster employeeMaster = employeeMasterRepository.findByUnameAndPass(uname, pass);
		//if(employeeMaster != null) {
			UserLogin userLogin = new UserLogin();
			userLogin.setName(employeeMaster.getEmployeename());
			userLogin.setUname(employeeMaster.getUname());
			userLogin.setEmpcode(employeeMaster.getEmployeeid());
			userLogin.setRolename(employeeMaster.getRole().getRolename());	
			return userLogin;
		//}
		}catch (Exception e) {
			// TODO: handle exception
			throw new EmployeeNotFound("Invalid Username and Password.");
		}
	}

}
