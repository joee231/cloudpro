<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="windows-1256">
<title>Edit Student</title>
</head>
<body>
<%@page import='com.student.information.Student' %>
<%@page import='com.student.information.StudentDao'%>
  
<%  
String username = (String)session.getAttribute("studentUsername");  
Student student = StudentDao.getStudentByUsername(username);  
%> 
 <div id="edit-profile" class="details">
                    <h3>Edit profile information.</h3>
                    
                    <form action="editStudent.jsp" method="POST">
                        <table class="edit">
                            <tr>
                                <td><div class="inputp"><input type="text" placeholder="First name" name="studentFirstName" value="<%=student.getStudentFirstName()%>"></div></td>
                                <td><div class="inputp"><input type="text" placeholder="Last name" name="studentLastName" value="<%=student.getStudentLastName()%>"></div></td>

                            </tr>
                            <tr>
                            
                                    <td colspan="2"><div class="inputp"><input type="text" name="studentUsername" value="<%=student.getStudentUsername()%>" readonly></div></td>
                                
                            </tr>
                            <tr>
                                <td><div class="inputp"><input type="email" placeholder="Email" name="studentEmail" value="<%=student.getStudentEmail()%>" ></div></td>
                                <td><div class="inputp"><input type="text" placeholder="Academic Year" name="studentLevel" value="<%=student.getStudentLevel()%>"></div></td>
   
                            </tr> 
                            <tr>
                                
                                <td colspan="2"><div class="inputp"><input type="password" name="studentPassword" placeholder="password" maxlength="30" minlength="8" value="<%=student.getStudentPassword()%>"></div></td>
                                
                            </tr> 
                        </table>
                        <button type="submit"> <i class="fa-regular fa-pen-to-square"></i> Update Profile</button>
                        
                    </form>
                </div>
</body>
</html>