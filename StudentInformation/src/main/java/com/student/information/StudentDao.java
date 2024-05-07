package com.student.information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
	public static void main(String[]args) throws SQLException {
		StudentDao.getConnection();
	}
	public static Connection getConnection()throws SQLException{
        Connection con = null;
			 String url = "jdbc:mysql://localhost/studentinformation";
			 con=DriverManager.getConnection(url,"habib","dbhabib");
				System.out.println("Connected!");
	        return con;
	}
	public static int insert(Student student) {
		 int state=0;
		 try {
			 String sql = "INSERT INTO `student`(`studentFirstName`,`studentLastName`,`studentLevel`,`studentUsername`,`studentPassword`,`studentEmail`) VALUES (?,?,?,?,?,?)";
				Connection con = StudentDao.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, student.getStudentFirstName());
				preparedStatement.setString(2, student.getStudentLastName());
				preparedStatement.setString(3, student.getStudentLevel());
				preparedStatement.setString(4, student.getStudentUsername());
				preparedStatement.setString(5, student.getStudentPassword());
				preparedStatement.setString(6, student.getStudentEmail());
				state = preparedStatement.executeUpdate();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		 return state;
	}
	public static int update(Student student) {
		 int state=0;
		 try {
			 String sql = "UPDATE `student` SET `studentFirstname`=?,`studentLastName`=?,`studentLevel`=?,`studentPassword`=?,`studentEmail`=? WHERE studentUsername=?";
				Connection con = StudentDao.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, student.getStudentFirstName());
				preparedStatement.setString(2, student.getStudentLastName());
				preparedStatement.setString(3, student.getStudentLevel());
				preparedStatement.setString(4, student.getStudentPassword());
				preparedStatement.setString(5, student.getStudentEmail());
				preparedStatement.setString(6, student.getStudentUsername());
				state = preparedStatement.executeUpdate();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		 return state;
	}
	public static int delete(Student student) {
		  int state=0;
		 try {
			 String sql = "DELETE FROM `student` WHERE studentUsername=?";
				Connection con =StudentDao.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, student.getStudentUsername());
				state = preparedStatement.executeUpdate();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		 return state;
	}
	public static Student getStudentByUsername(String username){  
		Student student=null;
	    try{  
	    	String sql = "SELECT * FROM student WHERE studentUsername=?";
			Connection con = StudentDao.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,username);  
	        ResultSet rs=preparedStatement.executeQuery();  
	        while(rs.next()){  
	        	student = new Student();  
	        	student.setStudentFirstName(rs.getString("studentFirstName"));
	        	student.setStudentLastName(rs.getString("studentLastName"));
	        	student.setStudentLevel(rs.getString("studentLevel"));
	        	student.setStudentUsername(rs.getString("studentUsername"));
	        	student.setStudentPassword(rs.getString("studentPassword"));
	        	student.setStudentEmail(rs.getString("studentEmail"));
	        	student.setStudentCGPA(rs.getFloat("studentCGPA"));
	        	student.setStudentID(rs.getString("studentID"));
	        	student.setStudentCreditHours(rs.getInt("studentCreditHours"));
	        	student.setStudentAge(rs.getInt("studentAge"));
	        }  
	    }
	    catch(SQLException e){
			e.printStackTrace(); 
	    }  
	   return student;  
	   }
	public static List<Student> getAllRecoreds(){  
		List<Student> students = new ArrayList<Student>();
	    try{  
	    	String sql = "SELECT * FROM student";
			Connection con = StudentDao.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
	        ResultSet rs=preparedStatement.executeQuery();
	        while(rs.next()){  
	        	Student student = new Student();  
	        	student.setStudentFirstName(rs.getString("studentFirstName"));
	        	student.setStudentLastName(rs.getString("studentLastName"));
	        	student.setStudentLevel(rs.getString("studentLevel"));
	        	student.setStudentUsername(rs.getString("studentUsername"));
	        	student.setStudentPassword(rs.getString("studentPassword"));
	        	student.setStudentEmail(rs.getString("studentEmail"));
	        	student.setStudentCGPA(rs.getFloat("studentCGPA"));
	        	student.setStudentID(rs.getString("studentID"));
	        	student.setStudentCreditHours(rs.getInt("studentCreditHours"));
	        	student.setStudentAge(rs.getInt("studentAge"));

	        	students.add(student);
	        }  
	    }
	    catch(SQLException e){
			e.printStackTrace(); 
	    }  
	    return students;
	   }
	public static String getPassword(String username) {
		  ResultSet rs = null;
		  Statement state = null;
		  String password = null;
		 try {
			 String sql = "SELECT * FROM `student` WHERE studentUsername="+"\""+username+"\"";
				Connection con =StudentDao.getConnection();
				 state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs = state.executeQuery(sql);
				 while(rs.next()) {
					 password = rs.getString(5);
				 }
				con.close();
				return password;
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		 return null;
	}
}
