package com.example.demo.service;

import com.example.demo.entity.Login;
import com.example.demo.exception.InvalidUserExeption;

public interface LoginService {

	void saveLoginData(Login login);
	
	Login loginCheck(String uname,String pass)throws InvalidUserExeption;
}
