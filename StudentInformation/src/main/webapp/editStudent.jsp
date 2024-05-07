<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit Student</title>
</head>
<body>
<%@ page import="com.student.information.StudentDao" %>
<%@ page import="com.student.information.Student" %>
	<jsp:useBean id="student" class="com.student.information.Student">	
		<jsp:setProperty name = "student" property = "*" ></jsp:setProperty>
	</jsp:useBean>
<% StudentDao.update(student); %>
<% String username = student.getStudentUsername(); %>
<% response.sendRedirect("profile.jsp#general"); %> 
</body>
</body>
</html>