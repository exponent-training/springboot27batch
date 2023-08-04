package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
import com.example.demo.repo.FileRepository;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public void saveFiledata(MultipartFile file) {
		// TODO Auto-generated method stub
		FileData fileData = new FileData();
		//fileData.setId(123);
		fileData.setFname(file.getOriginalFilename());
		fileData.setFtype(file.getContentType());
		try {
			fileData.setFdata(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileRepository.save(fileData);
		
	}

}
