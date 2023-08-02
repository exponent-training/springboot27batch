package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/useradd")
	public String saveUser(@RequestBody User user) {
		userService.userAdd(user);
		return "Data Inserted";
	}
	
	@PostMapping(value = "/buyproduct/{email}")
	public String buyProduct(@RequestBody Product product,@PathVariable String email) {
		System.out.println("Product Data : " + product +  "User Email : "+ email);
		userService.userBuyProduct(product, email);
		return "Product Buy";
	}
}
