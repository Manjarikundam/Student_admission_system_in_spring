<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.example.demo.Bean.*"%>
<%@page import=" org.springframework.web.client.RestTemplate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESULT</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
}

h1 {
	text-align: center;
	view_grad color: black
}
</style>
<body bgcolor="#a3a3a3">
	<h1>RESULT</h1>
	<br>
	<br>
	<form method="post">
		<table border="1" align="center">
			<thead>
				<tr>

					<th>appliant_no</th>
					<th>name</th>
					<th>dept_choice</th>
					<th>college_choice</th>
					<th>status</th>
				</tr>
			</thead>


			<%
				ApplicationBean bean=(ApplicationBean)request.getSession().getAttribute("name");
			%>
			<tr>

				<td><%=bean.getApplicant_no()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getDept_choice()%></td>
				<td><%=bean.getCollege_ch1()%></td>
				<td><%=bean.getStatus()%></td>

			</tr>
			

		</table>
</body>
</html>