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
	background-color: #95BFC0;
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

					<th>applicant_no</th>
					<th>name</th>
					<th>percentage</th>
					<th>Dept_choice</th>
					<th>college_choice</th>
				</tr>
			</thead>

			<%
				ArrayList<ApplicationBean> reviewlist = (ArrayList<ApplicationBean>) request
						.getAttribute("confirm");

				for (ApplicationBean dept : reviewlist) {
			%>
			<tr>


				<td><%=dept.getApplicant_no()%></td>
				<td><%=dept.getName()%></td>
				<td><%=dept.getPercentage()%></td>
				<td><%=dept.getDept_choice()%></td>
				<td><%=dept.getCollege_ch1()%></td>
				<td><a
					href="/acceptapplicant?applicant_no=<%=dept.getApplicant_no()%>">Accept</a></td>
				<td><a
					href="/rejectpage?applicant_no=<%=dept.getApplicant_no()%>">Reject</a></td>

			</tr>
			<%
				}
			%>

		</table>
</body>
</html>




