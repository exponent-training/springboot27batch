package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface UserService {

	void userAdd(User user);
	
	void userBuyProduct(Product product,String email);
}
