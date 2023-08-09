package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringBootJsonToJavaAndViceVersaExampleApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(SpringBootJsonToJavaAndViceVersaExampleApplication.class, args);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("================== Json To Java Conversion ===============");
		String str = "{\"id\": 1,\"name\": \"Ajas\",\"address\": \"Pune\",\"addr\": {\"id\":1,\"city\": \"PCMC\"}}";
		System.out.println("Json Data in String format : " + str);
		
		Employee employee = objectMapper.readValue(str, Employee.class);
		System.out.println("Java Object  : " + employee);
		
		System.out.println("================== Java To Json Conversion ===============");
		String str1 = objectMapper.writeValueAsString(employee);
		System.out.println("Json Object : " + str1);
		
	}

}
