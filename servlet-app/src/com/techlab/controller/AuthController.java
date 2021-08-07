package com.techlab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AuthController() {
        super();
        System.out.println("Authentication started");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Authentication succeded");
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Username: " + username + "</h1>");
		writer.println("<h1>password: " + password + "</h1>");
		writer.close();
	}

}
