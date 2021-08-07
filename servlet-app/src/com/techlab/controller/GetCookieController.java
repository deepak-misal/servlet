package com.techlab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getcookie")
public class GetCookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetCookieController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
	    Cookie[] cookies = null;
	    PrintWriter out=response.getWriter();
	    
	    cookies = request.getCookies();
	    
	    if( cookies != null ) {    
	       for (int i = 0; i < cookies.length; i++) {
	          cookie = cookies[i];
	          if(cookie.getName().equals("color")){
	                out.println("<h2> Found Cookies Name and Value</h2>");
	                out.println("<h1>color:"+cookie.getValue()+"</h1>"); 
	                out.println("<BODY BGCOLOR="+cookie.getValue()+"></body>");
	          }
	       }
	    } 
	    else {
	       out.println("<h2>No cookies founds</h2>");
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
