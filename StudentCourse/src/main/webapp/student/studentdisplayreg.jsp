<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
</head>
<body>
<font color="blue">${msg}</font><br><br>

<a href='<c:url value="/studentaddcourses"></c:url>'>back</a>
</body>
</html>