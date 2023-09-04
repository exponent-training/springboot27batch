package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.ApiEndpoint;
import com.example.demo.model.UserLogin;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping(value = ApiEndpoint.LOGIN)
	public ResponseEntity<UserLogin> getLoginData(@RequestParam String uname,@RequestParam String pass) {
		System.out.println("Login Credentials : " + uname + " " + pass);
		UserLogin userLogin = loginService.getLoginData(uname, pass);
		return ResponseEntity.ok(userLogin);
	}
	
}
