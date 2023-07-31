package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/")
	public String getIndexPage() {
		System.out.println("Index Page Calling");
		return "index";
	}
	
	@RequestMapping(value = "/reg")
	public String saveStudentData(@ModelAttribute Student student) {
		System.out.println("Studet Data : " + student);
		studentService.saveStudentData(student);
		return "index";
	}
}
