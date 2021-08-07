package com.techlab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session")
public class SessionController extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    public SessionController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		Integer newCount=(Integer)session.getAttribute("Counter");
		Integer oldCount;
		if(newCount== null||newCount==0){
		    oldCount=0;
		    newCount=1;
		}
		else{
		    oldCount=newCount;
		    newCount+=1;
		}
		session.setAttribute("Counter",newCount );
		out.println("<h1> Old: "+oldCount+"</h1>");
		out.println("<h1> New: "+newCount+"</h1>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
