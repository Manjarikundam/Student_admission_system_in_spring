<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subadmin</title>
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
background-color:lightgrey;
}

</style>
</head>
<body>
<h2><a href="index.jsp">Logout</a></h2>
<CENTER><fieldset id="f2">
<h1>admin functionalities</h1>

<form action="admin" method="get">


<h2 id="an"><a  href="/reviewApplications">applications review </a></h2>

<h2 id="an"><a  href="/selectedlist">selected studentslist</a></h2>
<h2 id="an"><a  href="/name">list of students for given department</a></h2>
<h2 id="an"><a  href="/confirm">confirmation page</a></h2>

</form>
</center>
</fieldset>
</CENTER>
</body>
</html>