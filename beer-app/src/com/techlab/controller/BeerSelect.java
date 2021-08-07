package com.techlab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlab.model.BeerExpert;


@WebServlet("/beerselect")
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BeerSelect() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c=request.getParameter("color");
		BeerExpert be=new BeerExpert();
		List result=be.getBrands(c);
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		out.println("Beer Selection Advice<br>");
		
		request.setAttribute("styles", result);
		RequestDispatcher view=request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
		
	}

}
