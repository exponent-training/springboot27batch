package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Login;
import com.example.demo.repo.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public void saveLoginData(Login login) {
		// TODO Auto-generated method stub
		System.out.println("In service Layer : " + login);
		loginRepository.save(login);
	}

	@Override
	public Login loginCheck(String uname, String pass) {
		// TODO Auto-generated method stub
		Login login = loginRepository.findByUnameAndPass(uname, pass);
		return login;
	}

}
