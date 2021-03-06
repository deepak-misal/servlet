package com.techlab.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.Student;
import com.techlab.service.IStudentService;
import com.techlab.service.StudentDBService;
import com.techlab.service.StudentServiceSingleton;


@WebServlet("/add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddController()
    {

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		RequestDispatcher view = request.getRequestDispatcher("add.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int rollNo =Integer.parseInt(request.getParameter("rollNo"));
		String name =request.getParameter("name");
		double cgpa =Double.parseDouble(request.getParameter("cgpa"));
		String location =request.getParameter("location");
		IStudentService service= new StudentDBService();
		service.addStudent(new Student(rollNo, name, cgpa, location));
		response.sendRedirect("http://localhost:8085/student-mvc-app/home"); 
	}

}