package com.techlab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setcookie")
public class SetCookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SetCookieController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("color");
		Cookie colorCookie=new Cookie("color", request.getParameter("color"));
		PrintWriter out=response.getWriter();
        colorCookie.setMaxAge(60*60*24*7);
        response.addCookie(colorCookie);
        out.println("<h1>Cookie set!</h1>");
        out.println("<h1> Value: "+value+"</h1>");
	}

}
