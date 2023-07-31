package com.example.demo.servce;

import java.util.List;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFound;

public interface HomService {

	void saveStudentData(Student student);
	
	Student getStudent(int sid)throws StudentNotFound;
	
	List<Student> getAllStudent();
	
	void updateStudent(Student student);
}
