<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<%@page import='com.student.information.Student' %>
<%@page import='com.student.information.StudentDao'%>
<%@page import='com.student.information.Subject' %>
<%@page import='com.student.information.SubjectDao'%>

<%@page import='java.sql.*'%>
<%@page import="java.util.*"%> 
<%
String username = (String)session.getAttribute("studentUsername"); 
%>            
                <div id="register" class="details">
                    <h3>Student's Registeration</h3>
                    <table class="sub">
 <% List<Subject> registered_list=SubjectDao.getAllRegisteredByUsername(username); %> 
<%for(Subject subject:registered_list){%> 
          <tr>
           <td><%=subject.getSubjectName()%><button class="btn" id="r" type="button" onclick="document.location='removeSubject.jsp?subjectID=<%=subject.getSubjectID()%>'">Remove</button></td>
          </tr>
       <%}%> 
     <% List<Subject> list=SubjectDao.getAllByUsername(username); %> 
<%for(Subject subject:list){%> 
	<tr>
         <td><%=subject.getSubjectName()%><button  class="btn" id="a" type="button" onclick="document.location='addSubject.jsp?subjectID=<%=subject.getSubjectID()%>'">Add</button></td>
	</tr>
       <%}%>    </table>
                </div>
<body>


</body>
</html>