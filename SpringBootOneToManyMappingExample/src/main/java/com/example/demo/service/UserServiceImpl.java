package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void userAdd(User user) {
		// TODO Auto-generated method stub
		System.out.println("User Data: " + user);
		userRepository.save(user);
	}

	@Override
	public void userBuyProduct(Product product, String email) {
		// TODO Auto-generated method stub
		if(email != null) {
			User user = userRepository.findByEmail(email);
			if(user != null) {
				user.getProducts().add(product);
				userRepository.save(user);
			}
		}
	}

}
