package com.techlab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/summary")
public class SummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SummaryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		
		PrintWriter out=response.getWriter();
		
		Integer sessionCount=(Integer)session.getAttribute("Counter");  
        Integer applicationCount=(Integer)application.getAttribute("Counter");
        
        out.println("<h1> Session Counter: "+sessionCount+"</h1>");
		out.println("<h1> Application Counter: "+applicationCount+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
