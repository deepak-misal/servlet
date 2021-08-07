<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.techlab.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<h1 align="center">Student List</h1>
<a style = "float : right" name="delete" value="add" class = 'btn btn-success' href = 'http://localhost:8085/student-mvc-app/add'>Add Student</a><br>
<% 
		List<Student> students = (List<Student>) request.getAttribute("studentList");
		int count = students.size();
		out.print("<h3> Student Count : " + count + "</h3>");
		out.print("<table class = 'table table-striped table-hover'>" +
						"<thead>" +
								"<tr>" +
									"<th>ID</th>" + 
									"<th>Name</th>" +
									"<th>Roll No</th>" +
									"<th>CGPA</th>" +
									"<th>Location</th>" +
									"<th>Edit</th>" +
									"<th>Delete</th>" +
								"</tr>" + 
						"</thead>");
		out.print("<tbody>");
		for (Student student : students)
		{
			out.print("<tr>");
				out.print("<td>" + student.getId() + "</td>");
				out.print("<td>" + student.getName() + "</td>");
				out.print("<td>" + student.getRollNo() + "</td>");
				out.print("<td>" + student.getCgpa() + "</td>");
				out.print("<td>" + student.getLocation() + "</td>");
				out.print("<td>");
				out.print("<form method = 'POST'>");
				out.print("<input type = 'hidden' name = 'operation' value = 'edit'>");
				out.print("<input type = 'hidden' name = 'guid' value = '" + student.getId() + "'>");
				out.print("<input type = 'hidden' name = 'name' value = '" + student.getName() + "'>");
				out.print("<input type = 'hidden' name = 'rollNo' value = '" + student.getRollNo() + "'>");
				out.print("<input type = 'hidden' name = 'cgpa' value = '" + student.getCgpa() + "'>");
				out.print("<input type = 'hidden' name = 'location' value = '" + student.getLocation() + "'>");
				out.print("<button type = 'submit' name='edit' value='edit' class = 'btn btn-info'> Edit </button>");
				out.print("</form>");
				out.print("</td>");
				out.print("<td>");
				out.print("<form method = 'POST'>");
				out.print("<input type = 'hidden' name = 'operation' value = 'delete'>");
				out.print("<input type = 'hidden' name = 'guid' value = '" + student.getId() + "'>");
				out.print("<button type = 'submit' name='delete' value='delete' class = 'btn btn-danger'> Delete </button>");
				out.print("</form>");
				out.print("</td>");
			out.print("</tr>");
		}
		out.print("</tbody>");
		out.print("</table>");
	%>
	<br><a style = "float : right"class = 'btn btn-success' href ="logout">Log out</a><br>
</body>
</html>