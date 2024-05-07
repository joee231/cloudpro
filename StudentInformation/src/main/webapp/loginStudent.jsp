<%@ page import="com.student.information.StudentDao" %>
<%@ page import="com.student.information.Student" %>
<%  
String username = request.getParameter("studentUsername"); 
String password = request.getParameter("studentPassword");
Student student = StudentDao.getStudentByUsername(username);
if(password.equals(StudentDao.getPassword(username))){
	session.setAttribute("studentUsername", username);
	response.sendRedirect("profile.jsp#general");  
} else {
	response.sendRedirect("loginForm.html");  
}
%> 
