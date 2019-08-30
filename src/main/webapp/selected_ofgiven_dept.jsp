<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.example.demo.Bean.*"%>
<%@page import=" org.springframework.web.client.RestTemplate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Applicants</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
	background-color:#95BFC0;
}

h1 {
	text-align: center;
	color: Tomato
}
</style>
<body>
	<h1>selected_students of given department </h1>
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
			ArrayList<Selected_studentsBean> reviewlist = (ArrayList<Selected_studentsBean>) request.getAttribute("list");
			
			for(Selected_studentsBean dept: reviewlist){
				%>
				<tr>

					
					<td><%=dept.getApplicant_no() %></td>
					<td><%= dept.getName()%></td>
					<td><%= dept.getPercentage()%></td>
					<td><%=dept.getAlloted_dept()%></td>
				<td><%=dept.getAlloted_college()%></td>

				</tr>
				<%
			}
			%>
		
		</table>
	
</body>
</html>




