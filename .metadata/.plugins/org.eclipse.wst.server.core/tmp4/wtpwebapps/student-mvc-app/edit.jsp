<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techlab.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<h2 style="text-align: center;">Student Update Form</h2><br>
<% 
		Student student = (Student) session.getAttribute("studentToEdit");
		
		out.print("<form method = 'POST' class='form-horizontal'>");
		
		out.print("<div class='form-group'>");
		out.println("<div class='col-sm-10'>");
		out.print("<input type = 'hidden' class = 'form-control'  name = 'GUID' value = " + "'" + student.getId() + "'" + "required>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='Name'class='col-sm-2 control-label'>Name</label>");
		out.println("<div class='col-sm-10'>");
		out.print("<input type = 'text' class = 'form-control'  name = 'name' value = " + "'" + student.getName() + "'" + "required>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='RollNo' class='col-sm-2 control-label'>RollNo</label>");
		out.println("<div class='col-sm-10'>");
		out.print("<input type = 'text' class = 'form-control'  name = 'rollNo' value = " + "'" + student.getRollNo() + "'" + " required>");
		out.print("</div>");
		out.print("</div>");
		 
		out.print("<div class='form-group'>");
		out.print("<label for='CGPA' class='col-sm-2 control-label'>CGPA</label>");
		out.println("<div class='col-sm-10'>");
		out.print("<input type = 'text' class = 'form-control'  name = 'cgpa' value = " + "'" + student.getCgpa() + "'" + " required>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='CGPA' class='col-sm-2 control-label'>Location</label>");
		out.println("<div class='col-sm-10'>");
		out.print("<input type = 'text' class = 'form-control'  name = 'location' value = " + "'" + student.getLocation() + "'" + " required>");
		out.print("</div>");
		out.print("</div>");
		  
		
		out.print("<input type='submit' value='Update' class='btn btn-primary'");
		out.print("</form>");
		
		%>
</body>
</html>