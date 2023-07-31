package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/savelogin")
	public String saveLoginDatawithPerson(@RequestBody Login login) {
		System.out.println("In Controller : " + login );
		loginService.saveLoginData(login);
		return "Data Inserted";
	}
	
	@GetMapping(value = "/login")
	public Login getLoginData(@RequestParam String uname,@RequestParam String pass) {
		System.out.println("Login Credentials : " + uname + " " + pass);
		Login login = loginService.loginCheck(uname, pass);
		return login;
	}
}
