package com.techlab.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.repository.StudentRepository;
import com.techlab.service.IStudentService;
import com.techlab.service.StudentDBService;


@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("delete.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentRepository repo=new StudentRepository();
		HttpSession session=request.getSession();
		String isDelete;
		if(request.getParameter("yes")!=null) {
			isDelete="yes";
		}
		else
			isDelete="no";
		if(isDelete.equals("yes")) {
			String id=(String) session.getAttribute("studentToDelete");
			System.out.println(id);
			IStudentService service= new StudentDBService();
			service.deleteStudent(id);
			response.sendRedirect("http://localhost:8085/student-mvc-app/home");
		}
		
	}

}
