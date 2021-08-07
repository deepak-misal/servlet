package com.techlab.model;

import java.util.UUID;

public class Student {
	private String id;
	private int rollNo;
	private String name;
	private double cgpa;
	private String location;
	public Student(String id,int rollNo,String name,double cgpa,String location) {
		this.id=id;
		this.rollNo=rollNo;
		this.name=name;
		this.cgpa=cgpa;
		this.location=location;
	}
	
	public Student(int rollNo,String name,double cgpa,String location) {
		this.id=this.id = UUID.randomUUID().toString();
		this.rollNo=rollNo;
		this.name=name;
		this.cgpa=cgpa;
		this.location=location;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public double getCgpa() {
		return cgpa;
	}
	public String getLocation() {
		return location;
	}

}
