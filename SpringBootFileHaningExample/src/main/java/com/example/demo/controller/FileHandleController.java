package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
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
	
	@GetMapping(value = "/file/{id}")
	public ResponseEntity<?> getFileData(@PathVariable int id) {
		System.out.println("File Id : " + id);
		FileData fileData = fileService.getFileDataUsingId(id);
		if(fileData != null) {
		return ResponseEntity.status(HttpStatus.OK)
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment: filename =\""+fileData.getFname()+"\"")
			.body(fileData.getFdata());
		} else {
			return ResponseEntity.ok("No Value Found.");
		}
	}

}
