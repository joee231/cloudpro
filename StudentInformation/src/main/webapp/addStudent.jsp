<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="com.student.information.StudentDao" %>
	<%@ page import="com.student.information.Student" %>
	<jsp:useBean id="student" class="com.student.information.Student">	
			<jsp:setProperty name = "student" property = "*" ></jsp:setProperty>
	</jsp:useBean>
	<% 
		int message = StudentDao.insert(student);
		if(message > 0){
			response.sendRedirect("StudentAdded.jsp");
		} else {
			response.sendRedirect("StudentFaild.jsp");
		}
	%>

</body>
</html>