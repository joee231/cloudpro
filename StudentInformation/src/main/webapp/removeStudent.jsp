<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Remove Student</title>
</head>
<body>
<%@ page import="com.student.information.StudentDao" %>
<%@ page import="com.student.information.Student" %>
	<jsp:useBean id="student" class="com.student.information.Student">	
			<jsp:setProperty name = "student" property = "*" ></jsp:setProperty>
	</jsp:useBean>
<%  
StudentDao.delete(student);  
response.sendRedirect("viewStudent.jsp");  
%> 
</body>
</body>
</html>