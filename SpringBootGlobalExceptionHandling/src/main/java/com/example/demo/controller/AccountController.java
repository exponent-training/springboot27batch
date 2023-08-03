package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.AccountNotFound;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/account/{aname}/{email}")
	public Account getAccountData(@PathVariable String aname,@PathVariable String email) throws AccountNotFound {
		System.out.println("Path Variable Value : " + aname + "  " + email);
		Account account = accountService.getAccountData(aname, email);
		return account;
	}
}
