package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFound;
import com.example.demo.servce.HomService;

@RestController
public class HomeController {
	
	@Autowired
	private HomService homService;
	
	@PostMapping(value = "/savestu")
	public String saveStudentData(@RequestBody Student student) {
		System.out.println("In Controller :" + student);
		homService.saveStudentData(student);
		return "Data Stored.";
	}
	
	@GetMapping(value = "/get/{id}")
	public Student getStudent(@PathVariable("id") int sid) {
		System.out.println("Student id : " + sid);
		try {
			Student student = homService.getStudent(sid);
			return student;
		} catch (StudentNotFound e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return new Student("Student Id not found.");
	}
	
	@GetMapping(value = "/getAll")
	public List<Student> getAllStudentData(){
		List<Student> slist = homService.getAllStudent();
		return slist;
	}
	
	@PutMapping(value = "/up")
	public String updatngData(@RequestBody Student student) {
		homService.updateStudent(student);
		return "Data updated.";
	}

}
