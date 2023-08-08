package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
import com.example.demo.repo.FileRepository;

@Service
public class FileServiceImpl implements FileService{

	public static final String UPLOAD_DIR="F:\\fileHandle\\";
	
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

	@Override
	public FileData getFileDataUsingId(int id) {
		// TODO Auto-generated method stub
		try {
		 FileData fileData = fileRepository.findById(id).get();
		 //Byte Array store in file at drive location.
		 Path path = Paths.get(UPLOAD_DIR+fileData.getFname());
		 try {
			Files.write(path, fileData.getFdata());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return fileData;
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

}
