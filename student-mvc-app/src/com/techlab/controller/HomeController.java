package com.techlab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.Student;
import com.techlab.repository.StudentRepository;
import com.techlab.service.IStudentService;
import com.techlab.service.StudentDBService;
import com.techlab.service.StudentServiceSingleton;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService service= new StudentDBService();
		List<Student> students=service.getList();
				
		request.setAttribute("studentList", students);
		RequestDispatcher view=request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		StudentRepository repo=new StudentRepository();
		HttpSession session = request.getSession();
		
		switch (operation)
		{
			case "edit":
				String UUID = request.getParameter("guid");
				String name = request.getParameter("name");
				int rollNo = Integer.parseInt(request.getParameter("rollNo"));
				double cgpa = Double.parseDouble(request.getParameter("cgpa"));
				String location = request.getParameter("location");
				
				Student student = new Student(UUID, rollNo, name, cgpa, location);
				
				session.setAttribute("studentToEdit", student);
				session.setAttribute("operation", "edit");
				response.sendRedirect("http://localhost:8085/student-mvc-app/edit");
				break;
			case "delete":
				try
				{
					String GUID = request.getParameter("guid");
					//repo.deleteStudent(GUID);
					
					session.setAttribute("studentToDelete", GUID);
					session.setAttribute("operation", "delete");
					response.sendRedirect("http://localhost:8085/student-mvc-app/delete");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
		}
	}

}
