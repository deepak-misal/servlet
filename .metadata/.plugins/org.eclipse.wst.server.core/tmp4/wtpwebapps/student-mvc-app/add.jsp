<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<h2 style="text-align: center;">Student Registration Form</h2><br>
<form action="add" method="POST" class="form-horizontal">
	<div class="form-group">
		<label for="rollNo" class="col-sm-2 control-label">Roll No:</label>
		<div class="col-sm-10">
			<input type="text" id="rollNo" name="rollNo" class="form-control" required><br>
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<input type="text" id="name" name="name" class="form-control" required><br>
		</div>
	</div>
    <div class="form-group">
		<label for="cgpa" class="col-sm-2 control-label">CGPA:</label>
		<div class="col-sm-10">
			<input type="text" id="cgpa" name="cgpa"  class="form-control" required><br>
		</div>
	</div> 
	<div class="form-group">
		<label for="location" class="col-sm-2 control-label">Location:</label>
		<div class="col-sm-10">
			<input type="text" id="location" name="location" class="form-control"required><br>
		</div>
	</div>     
    <div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			 <button type="submit" formmethod="POST" class='btn btn-primary'>Add</button>    
		</div>
	</div>           
       
</form>
<script>
		function goToHomePage() {
			window.location.href="http://localhost:8080/student-mvc-app/home";
		}
</script>
</body>
</html>