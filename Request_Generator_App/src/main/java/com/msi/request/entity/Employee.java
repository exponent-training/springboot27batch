package com.msi.request.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int empcode;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String uname;
	
	private String pass;
	
	private String designation;
	
	private String technology;
	
	private String dateofjoin;
	
	private String dateofbirth;
	
	private String managername;
	
	private String contactno;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private Role role;
	
}
