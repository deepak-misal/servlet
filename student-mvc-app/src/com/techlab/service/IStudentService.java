package com.techlab.service;

import java.util.List;

import com.techlab.model.Student;

public interface IStudentService {

	public List<Student> getList();

	public void addStudent(Student student);
	
	public void updateStudent(Student student);

	public void deleteStudent(String id);

}