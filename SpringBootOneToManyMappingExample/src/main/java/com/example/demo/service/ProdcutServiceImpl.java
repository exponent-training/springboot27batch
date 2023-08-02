package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

@Service
public class ProdcutServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Product Data : " + product);
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllData() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
