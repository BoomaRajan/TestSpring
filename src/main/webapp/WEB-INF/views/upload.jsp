<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.lang.*,java.util.*"%>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>
</head>
<body >
<form action = "processFile" method = "post" enctype="multipart/form-data">
<table>
<tr>
<td><input type ="file" name = "file"></td>
<td><input type="submit" name = "upload"></td> 
</tr>
</table>


</form>


<table >
<tr>
<td> <h1>
<%
		Map result = (Map) request.getAttribute("result");
		List passResult = (List)result.get("Pass");
		List FailResult = (List)result.get("Fail");

out.println("File Name = "+result);
%>
</h1></td>
</tr>

</table>
</body>
</html>