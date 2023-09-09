package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Incident {

	@Id
	private int id;
	
	private String incidentnumber;
	
	private String catogory;
	
	private String subcatogory;
	
	private String desklocation;
	
	private String urgency;
	
	private String location;
	
	private String currentlyat;
	
	private String contactnumber;
	
	private String catdescription;
	
	private String remark;
	
	private String status;
	
	private String createdby;
	
	private String createddate;
	
	private String updatedby;
	
	private String updateddate;
	
	private String assignedto;
	
	private String resolvedby;
	
	private String resolveddate;
}
