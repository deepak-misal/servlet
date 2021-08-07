package com.techlab.service;

import java.sql.SQLException;
import java.util.List;

import com.techlab.model.Student;
import com.techlab.repository.StudentRepository;

public class StudentDBService implements IStudentService{
	StudentRepository repo=new StudentRepository();

	@Override
	public List<Student> getList() {
		try {
			List<Student> studentList=repo.getDbList();
			return studentList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void addStudent(Student student) {
		try {
			repo.addStudentToDb(student);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStudent(Student student) {
		try {
			repo.updateStudent(student);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void deleteStudent(String id) {
		try {
			repo.deleteStudent(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
