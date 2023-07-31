package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void saveStudentData(Student student) {
		// TODO Auto-generated method stub
		System.out.println("In Service Layer  : " + student);
		studentDao.saveStudentData(student);
	}

}
