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
	<center>
		<h1>your application has been rejected</h1>
		<h2>re_apply for other college</h2>
	</center>
	<h2><a  href="index.jsp">Logout</a></h2>
	
	<br>
	<br>
	<form action="/edit">
		<table border="1" align="center">



			<%
				ApplicationBean bean = (ApplicationBean) request.getSession().getAttribute("name");
			%>
			<tr>
				<th>Applicant_no</th>
				<td><%=bean.getApplicant_no()%></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><%=bean.getName()%></td>
			</tr>
			<tr>
				<th>Percentage</th>
				<td><%=bean.getPercentage()%></td>
			</tr>
			<tr>
				<th>Dept_choice</th>
				<td><select name=dept_choice>
						<option value="cse">CSE</option>
						<option value="ece">ECE</option>
						<option value="it">IT</option>
						<option value="mech">MECH</option>
				</select></td>
			</tr>
			<tr>
				<th>College_choice</th>
				<td><select name="college_ch1">
						<option value="CMRTC">CMRTC</option>
						<option value="CMRIT">CMRIT</option>
						<option value="CMRCET">CMRCET</option>
						<option value="CMREC">CMREC</option>
				</select>
				<td>
			</tr>
		</table>
		<center>
			<tr>
				<td><input type="submit" value="APPLY"></td>
			</tr>
		</center>
</body>
</html>