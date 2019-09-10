<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.student_admission.Bean.*"%>
<%@page import=" org.springframework.web.client.RestTemplate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	padding-left: 700px;
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
	height: 450px;
	background-color: rgb(84, 115, 117,0.6);
}
</style>
<body>
	<CENTER>
		<fieldset id="f2">
			<h1>View Admins</h1>
			<br> <br>
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
	</CENTER>
</body>
</html>