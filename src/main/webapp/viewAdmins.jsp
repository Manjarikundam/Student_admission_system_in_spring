<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.example.demo.Bean.*"%>
<%@page import=" org.springframework.web.client.RestTemplate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1>List of Applicants</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>
					<th>college code</th>
					<th>college name</th>
					<th>Admin name</th>
				</tr>
			</thead>
			<%
				ArrayList<ClgadminBean> bean = (ArrayList<ClgadminBean>) request.getAttribute("admins");

				for (ClgadminBean login : bean) {
					
			%>
			<tr>
				
				<td><%=login.getClgcode()%></td>
				<td><%=login.getClgname()%></td>
				<td><%=login.getAdminname()%></td>
			</tr>
			<%
				}
			%>



		</table>
</body>
</html>