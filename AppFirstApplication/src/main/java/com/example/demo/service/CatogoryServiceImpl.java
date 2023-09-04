package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repo.CategoryRepository;

@Service
public class CatogoryServiceImpl implements CatogoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void saveCatogoryInfo(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
	}

}
