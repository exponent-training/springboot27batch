package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.ApiEndpoint;
import com.example.demo.entity.Category;
import com.example.demo.service.CatogoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CatogoryService catogoryService;

	@PostMapping(value = ApiEndpoint.SAVE_CATOGORY)
	public void saveCatogoryData(@RequestBody Category category) {
		System.out.println("Catogory Save --- > Starting....!");
		System.out.println("Category Data : " + category);
		catogoryService.saveCatogoryInfo(category);
		System.out.println("Catogory Save --- > Ending....!");
	}
	
}
