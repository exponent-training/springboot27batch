package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.io.ICsvWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.demo.model.Student;

@RestController
public class HomeController {

	@GetMapping(value = "/export")
	public void exportDataToCsvFile(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String date = dateFormat.format(new Date());
		
		response.setHeader("Content-Disposition", "attachment; filename=users_" +date+ ".csv");
		
		Student student = new Student();
		student.setId(1);student.setName("A");student.setAddress("Pune");
		student.setUname("admin");student.setPass("admin");
		
		Student student1 = new Student();
		student1.setId(1);student1.setName("A");student1.setAddress("Pune");
		student1.setUname("admin");student1.setPass("admin");
		
		Student student2 = new Student();
		student2.setId(1);student2.setName("A");student2.setAddress("Pune");
		student2.setUname("admin");student2.setPass("admin");
		
		List<Student> list = new ArrayList<Student>();
		list.add(student);list.add(student1);list.add(student2);
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = {"User ID","NAME","ADDRESS","USERNAME","PASSWORD"};
		String[] csvnameMapping = {"id","name","address","uname","pass"};
		
		csvWriter.writeHeader(csvHeader);
		
		for(Student stu : list) {
			csvWriter.write(stu, csvnameMapping);
		}
		
		csvWriter.close();
	}
}
