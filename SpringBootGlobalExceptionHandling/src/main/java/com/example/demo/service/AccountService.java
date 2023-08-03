package com.example.demo.service;

import com.example.demo.exception.AccountNotFound;
import com.example.demo.model.Account;

public interface AccountService {

	Account getAccountData(String aname,String atype)throws AccountNotFound;
}
