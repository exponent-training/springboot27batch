package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exception.AccountNotFound;
import com.example.demo.model.Account;

@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public Account getAccountData(String aname, String email) throws AccountNotFound {
		// TODO Auto-generated method stub
		
		
		if("admin".equals(aname) && "admin@gmail.com".equals(email)) {
			
			Account account = new Account();
			account.setAid(123);account.setAname("admin");
			account.setAtype("saving");account.setEmail("admin@gmail.com");
			
			return account;
		}else {
			throw new AccountNotFound("Account Not Present.");
		}
	}

}
