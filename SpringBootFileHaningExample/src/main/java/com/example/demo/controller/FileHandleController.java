package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileService;

@RestController
public class FileHandleController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping(value = "/upload")
	public String getFilData(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		fileService.saveFiledata(file);
		return "File Upload.";	
	}

}
