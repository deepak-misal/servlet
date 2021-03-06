package com.techlab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.LoginBean;
import com.techlab.service.AuthenticationService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginBean login=new LoginBean(username,password);
		AuthenticationService service=new AuthenticationService();
		String userValidate=service.authenticateUser(login);
		String buttonValue=request.getParameter("edit");
		System.out.println(buttonValue);
		if(userValidate.equals("Admin")) {
			System.out.println("Admin");
			HttpSession session=request.getSession();
			session.setAttribute("Admin",username);
			request.setAttribute("username", username);
			String pageToLoad=(String) session.getAttribute("operation");
			if(pageToLoad=="edit") {
				response.sendRedirect("http://localhost:8085/student-mvc-app/"+pageToLoad);
			}
			else if(pageToLoad=="delete") {
				response.sendRedirect("http://localhost:8085/student-mvc-app/home");
			}
			else if(pageToLoad==null) {
				response.sendRedirect("http://localhost:8085/student-mvc-app/add.jsp");
			}
			
		}
		else {
			System.out.println("Error");
			System.out.println(userValidate);
			request.setAttribute("errMessage", userValidate);
			response.sendRedirect("http://localhost:8085/student-mvc-app/login.jsp");	
		}
	}

}
