<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
#an{
align:center;

}
td{
padding:10px;
border:none;
}
#f2{
width:400px;
height:450px;
background-color: rgb(84, 115, 117,0.6);
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
</head>
<body>

<CENTER><fieldset id="f2">
<h1>ADD ADMIN</h1>
<form action="add_admins" method="post">

<table>
<tr>
<td>college code:<input type="text" name="clgcode" required></td>
<td>college_name:<input type="text" name="clgname" required></td>
</tr>


<tr>
<td>admin_name:<input type="text" name="adminname" required></td>
</tr>

<tr>
<td></td>

<td><input type="submit" value="APPLY"></td> 
 </tr>

</table>


</form>
</center>
</fieldset>
</CENTER>
</body>
</html>