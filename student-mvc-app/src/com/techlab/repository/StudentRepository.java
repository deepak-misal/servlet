package com.techlab.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.techlab.model.Student;

public class StudentRepository {
	private Connection con;
	public StudentRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student?" +
					 "user=root&password=root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addStudentToDb(Student student) throws SQLException, ClassNotFoundException {
		
		String sql="INSERT INTO STUDENTS (ID,ROLLNO,NAME,CGPA,LOCATION) VALUES(?,?,?,?,?)";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		
		statement.setString(1, UUID.randomUUID().toString());
		statement.setInt(2, student.getRollNo());
		statement.setString(3, student.getName());
		statement.setDouble(4,student.getCgpa());
		statement.setString(5, student.getLocation());
		
		int result=statement.executeUpdate();
		if(result>0) {
			System.out.println("Row Inserted");
		}
	}
	public List<Student> getDbList() throws ClassNotFoundException, SQLException{
		List<Student> studentList=new ArrayList<Student>();
		
		Statement stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID,ROLLNO,NAME,CGPA,LOCATION FROM STUDENTS");
        
        while(rs.next()) {
        	Student student=new Student(rs.getInt("ROLLNO"),rs.getString("NAME"),rs.getDouble("CGPA"),rs.getString("LOCATION"));
        	student.setId(rs.getString("ID"));
        	studentList.add(student);
        }
		return studentList;
	}
	public void updateStudent(Student student) throws ClassNotFoundException, SQLException {
		
		String sql="UPDATE STUDENTS SET ROLLNO=?,NAME=?,CGPA=?,LOCATION=? WHERE ID='"+student.getId()+"';";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		statement.setInt(1, student.getRollNo());
		statement.setString(2, student.getName());
		statement.setDouble(3,student.getCgpa());
		statement.setString(4, student.getLocation());
		
		int result=statement.executeUpdate();
		if(result>0) {
			System.out.println("Row Updated");
		}
	}
	public void deleteStudent(String id) throws ClassNotFoundException, SQLException {
		
		String sql="DELETE FROM STUDENTS WHERE ID='"+id+"';";
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
		
		int result=statement.executeUpdate();
		if(result>0) {
			System.out.println("Row Deleted");
		}
	}
}
