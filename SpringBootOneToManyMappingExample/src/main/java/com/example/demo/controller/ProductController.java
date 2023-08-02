package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/productadd")
	public String addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	  return "Product Successfully added.";
	}
	
	@GetMapping(value = "/getAll")
	public List<Product> getAllData(){
		List<Product> list = productService.getAllData();
		return list;
	}
}
