<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
</head>
<body>
<%@page import='com.student.information.Student' %>
<%@page import='com.student.information.StudentDao'%>
<%@page import='com.student.information.Subject' %>
<%@page import='com.student.information.SubjectDao'%>

<%@page import='java.sql.*'%>
<%@page import="java.util.*"%> 
<%String username = (String)session.getAttribute("studentUsername"); %>
<div id="grades" class="details">
                    <h3>Student's Grades</h3>
                    <table class="sub">
                          <% List<Subject> list=SubjectDao.getAllRecoredsByUsername(username); %> 
<%for(Subject subject:list){%> 
  <tr>
                            <td> <p><%=subject.getSubjectID()%></p> <p><%=subject.getSubjectName()%></p>
                            <span class="grade"><%=subject.getSubjectGrade()%> </span> </td>
                        </tr>
       <%}%> 
                    </table>
                </div>
</body>
</html>