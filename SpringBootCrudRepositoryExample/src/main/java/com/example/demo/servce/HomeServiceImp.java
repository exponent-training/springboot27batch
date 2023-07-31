package com.example.demo.servce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFound;
import com.example.demo.repo.HomeRepository;

@Service
public class HomeServiceImp implements HomService{
	
	@Autowired
	private HomeRepository homeRepository;

	@Override
	public void saveStudentData(Student student) {
		// TODO Auto-generated method stub
		System.out.println("In Service Layer : " + student);
		homeRepository.save(student);
	}

	@Override
	public Student getStudent(int sid) throws StudentNotFound {
		// TODO Auto-generated method stub
		Student student = null;
		try {
		 student = homeRepository.findById(sid).get();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new StudentNotFound("Student Not Found");
		}
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> list = (List<Student>) homeRepository.findAll();
		return list;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("Updated Data : " + student);
		homeRepository.save(student);
	}

}
