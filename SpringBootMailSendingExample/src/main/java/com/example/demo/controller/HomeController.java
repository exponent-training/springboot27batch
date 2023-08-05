package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping(value = "/sending")
	public String sendMail() {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("ajasshaikh8390@gmail.com");
		simpleMailMessage.setSubject("Testing - Java code send a mail.");
		simpleMailMessage.setText("Hi Team, This is your Teting mail send by Anon Team.");
		
		javaMailSender.send(simpleMailMessage);
		
		return "Send mail Successfully.";
	}
	

}
