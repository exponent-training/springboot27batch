package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employeemasterdetails")
public class EmployeeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String employeename;
	
	private String accountname;
	
	private String contactnumber;
	
	@Column(name="designation",nullable = false)
	@NotEmpty(message = "Please Add Some Data")
	private String designation;
	
	private String department;
	
	private String employeeid;
	
	private String project;
	
	private String reportingmanager;
	
	private String uname;
	
	private String pass;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private Role role;
	
	
}
