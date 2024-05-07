<%@page import='com.student.information.Student' %>
<%@page import='com.student.information.StudentDao'%>
<%@page import='com.student.information.Subject' %>
<%@page import='com.student.information.SubjectDao'%>
<%
String username = (String)session.getAttribute("studentUsername"); 
String subjectID = request.getParameter("subjectID");
SubjectDao.delete(subjectID,username);  
response.sendRedirect("profile.jsp#register");  
%>