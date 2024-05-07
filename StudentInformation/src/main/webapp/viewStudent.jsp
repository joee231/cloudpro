<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@page import='com.student.information.Student' %>
<%@page import='com.student.information.StudentDao'%>
<%@page import='java.sql.*'%>
<%@page import="java.util.*"%>  
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 --%>   
<table class="table table-light  table-hover position-absolute top-50 start-50 translate-middle">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Firstname</th>
      <th scope="col">Lastname</th>
      <th scope="col">Level</th>
      <th scope="col">Username</th>
      <th scope="col">Password</th>
      <th scope="col">Email</th>
    </tr>
  </thead>
      <% List<Student> list=StudentDao.getAllRecoreds(); %> 
      <% int count=0; %>
<%  for(Student s:list){   %> 
     <tbody class="table-group-divider">
      <tr>
        <th scope="row"><%=++count%></th>
        <td><%= s.getStudentFirstName() %></td>
        <td><%= s.getStudentLastName() %></td>
        <td><%= s.getStudentLevel() %></td>
        <td><%= s.getStudentUsername() %></td>
        <td><%= s.getStudentPassword() %></td>
        <td><%= s.getStudentEmail() %></td>
        <td>
        <a type="button" class="btn btn-warning" href="StudentEdit.jsp?studentUsername=<%=s.getStudentUsername()%>">Edit</a>
		<a type="button" class="btn btn-danger" href="removeStudent.jsp?studentUsername=<%=s.getStudentUsername()%>">Remove</a>
		</td>
      </tr>
    </tbody>
         <% }    %> 
</table>
    

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>