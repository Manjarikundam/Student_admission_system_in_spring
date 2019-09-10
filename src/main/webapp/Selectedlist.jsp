<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.student_admission.Bean.*"%>
<%@page import=" org.springframework.web.client.RestTemplate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selected_students</title>
</head>
<style>
body {
	padding-left: 550px;
	padding-top: 50px;
	padding-bottom: 90px;
	background-image:
		url("https://www.thoughtco.com/thmb/JBypVycd1rBteuuRf-qFkUO-jVQ=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/173253837-56a18f0c5f9b58b7d0c0a855.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

h1 {
	text-align: center;
	color: Tomato
}
#f2 {
	width: 400px;
	height: 350px;
	background-color:lightgrey;
}
</style>
<body>
<CENTER>
		<fieldset id="f2">
	<h1>List of Selected_students</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>

					<th>applicant_no</th>
					<th>name</th>
					<th>percentage</th>
					<th>alloted_dept</th>
					<th>alloted_college</th>
				</tr>
			</thead>

			<%
				ArrayList<Selected_studentsBean> reviewlist = (ArrayList<Selected_studentsBean>) request
						.getAttribute("selected");

				for (Selected_studentsBean dept : reviewlist) {
			%>
			<tr>


				<td><%=dept.getApplicant_no()%></td>
				<td><%=dept.getName()%></td>
				<td><%=dept.getPercentage()%></td>
				<td><%=dept.getAlloted_dept()%></td>
				<td><%=dept.getAlloted_college()%></td>

			</tr>
			<%
				}
			%>

		</table>
		</CENTER>
</body>
</html>




