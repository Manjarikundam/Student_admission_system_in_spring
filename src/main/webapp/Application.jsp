<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.student_admission.Bean.*"%>
<%@page import=" org.springframework.web.client.RestTemplate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<style type="text/css">
#an {
	align: center;
}

td {
	padding: 10px;
	border: none;
}

#f2 {
	width: 400px;
	height: 450px;
	background-color: rgb(84, 115, 117,0.7);
}

body {
	padding-left: 700px;
	padding-top: 50px;
	padding-bottom: 90px;
	background-image:
		url("https://www.thoughtco.com/thmb/JBypVycd1rBteuuRf-qFkUO-jVQ=/768x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/173253837-56a18f0c5f9b58b7d0c0a855.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
	<script>
		function ssc() {
			document.getElementById("id3").disabled = true;

		}
		function cbse() {
			document.getElementById("id3").disabled = false;
		}

		function myFunction() {
			var x = document.getElementById("mySelect").options[0].text;

		}
	</script>
</head>
<body>

	<%
		List<String> departments = (List<String>) request.getAttribute("deptlist");
	%>
	<CENTER>
		<fieldset id="f2">
			<h1>student application form</h1>
			<form action="/insertapplicant" method="post">
				<table>
					<tr>
						<td>name:<input type="text" name="name" required></td>
						<td>password:<input type="password" name="password" required></td>
					</tr>
					<tr>
						ssc
						<input onclick="ssc()" type="radio" name="board" value="ssc">
						cbse
						<input onclick="cbse()" type="radio" name="board" value="cbse">

						<td>percentage:<input id="id4" type="text" name="percentage"
							required></td>
						<td>gpa:<input id="id3" type="text" name="gpa" required></td>

					</tr>

					<tr>
						<td>school_name:<input type="text" name="school_name"
							required></td>
						<td>Dept choice: <select name=dept_choice>
								<option value="cse">CSE</option>
								<option value="ece">ECE</option>
								<option value="it">IT</option>
								<option value="mech">MECH</option>
						</select></td>

					</tr>
					<tr>
						<td>College_choice<select name="college_ch1">
								<%
									for (int i = 0; i < departments.size(); i++) {
										out.println("<option value=" + departments.get(i) + ">" + departments.get(i) + "</option>");
									}
								%>
						</select></td>

						<td><input type="submit" value="APPLY"></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</CENTER>
</body>
</html>