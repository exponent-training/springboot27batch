package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	void addProduct(Product product);
	
	List<Product> getAllData();
}
