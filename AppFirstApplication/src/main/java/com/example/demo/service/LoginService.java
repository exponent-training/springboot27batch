package com.example.demo.service;

import com.example.demo.model.UserLogin;

public interface LoginService {
	
	UserLogin getLoginData(String uname,String pass);

}
