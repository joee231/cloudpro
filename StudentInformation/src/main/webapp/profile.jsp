<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
         <title>Profile</title>
         <meta charset="UTF-8"/>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="css/stylep.css"> 
         <script src="fontawesome.js"></script>
         <link rel="stylesheet" href="css/googleapis.css" />
</head>
<body>
<%@ page import="com.student.information.StudentDao" %>
<%@ page import="com.student.information.Student" %>
<%  
String username = (String)session.getAttribute("studentUsername");  
Student student = StudentDao.getStudentByUsername(username);
%> 
        <div class="container clearfix">
            <div class="sidebar">
               <div class="p-icon"><i class="fa-solid fa-user fa-lg"></i></div>
                <nav>
                    <a href="#general">Information</a>
                </nav>
                <nav> 
                    <a href="#grades">Grades</a>
                </nav>
                <nav> 
                    <a href="#register">Registeration</a>
                </nav>
                <nav> 
                    <a href="#edit-profile">Edit information</a>
                </nav>
                <nav> 
                    <a href="logoutStudent.jsp"><i class="fa-solid fa-arrow-right-from-bracket"></i> Logout</a>
                </nav>
            </div>

            <div class="student-profile">
                
                <div id="general" class="details">
                    <div class="profile">
                        <div class="profile-header"> 
                            <span class="material-symbols-outlined" id="acc">
                                account_circle
                                </span>
                        </div>
                        <div class="profile-body">
                              <table class="info">
                                <tr>
                                    <td><b>Name:</b></td>
                                    <td><%=student.getStudentFirstName()+" "+student.getStudentLastName()%></td>
                                </tr>
                                <tr>
                                    <td><b>Student ID:</b></td>
                                    <td><%=student.getStudentID()%></td>
                                </tr> 
                                <tr>
                                    <td><b>Age:</b></td>
                                    <td><%=student.getStudentAge()%></td>
                                </tr> 
                                <tr>
                                    <td><b>Academic Level:</b></td>
                                    <td><%=student.getStudentLevel()%> year</td>
                                </tr> <tr>
                                    <td><b>CGPA:</b></td>
                                    <td><%=student.getStudentCGPA()%></td>
                                </tr> <tr>
                                    <td><b>Credit Hours:</b></td>
                                    <td><%=student.getStudentCreditHours()%></td>
                                </tr>
                              </table>
                        </div>
                    </div>
                </div>
	<jsp:include page="viewSubjects.jsp"></jsp:include>
    <jsp:include page="viewRegistration.jsp"></jsp:include>
    <jsp:include page="StudentEdit.jsp"></jsp:include>        
            </div>
        </div>
</body>
</html>