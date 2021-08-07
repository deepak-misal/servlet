package com.techlab.service;

import java.util.ArrayList;
import java.util.List;

import com.techlab.model.Student;

public class StudentService implements IStudentService {
	List<Student> studentList=new ArrayList<Student>();
	public StudentService() {
		studentList.add(new Student(1,"abc",9.5,"mumbai"));
		studentList.add(new Student(2,"abc",9.5,"mumbai"));
		studentList.add(new Student(3,"abc",9.5,"mumbai"));
		studentList.add(new Student(4,"abc",9.5,"mumbai"));
	}
	@Override
	public List<Student> getList(){
		return studentList;
	}
	@Override
	public void addStudent(Student student) {
		studentList.add(student);
	}
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		
	}
	
}
