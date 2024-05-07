package com.student.information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
	public static void main(String[]args) throws SQLException {
		SubjectDao.getConnection();
	}
	public static Connection getConnection()throws SQLException{
        Connection con = null;
			 String url = "jdbc:mysql://localhost/studentinformation";
			 con=DriverManager.getConnection(url,"habib","dbhabib");
				System.out.println("Connected!");
	        return con;
	}
	public static int insert(String subjectID, String username) {
		 int state=0;
		 try {
			 String sql = "INSERT INTO `registration_subject`(`subjectID`,`studentUsername`) VALUES (?,?)";
				Connection con = StudentDao.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, subjectID);
				preparedStatement.setString(2, username);
				state = preparedStatement.executeUpdate();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		 return state;
	}
	public static int delete(String subjectID, String username) {
		  int state=0;
		 try {
			 String sql = "DELETE FROM `registration_subject` WHERE studentUsername=? AND subjectID =?";
				Connection con =StudentDao.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, subjectID);
				state = preparedStatement.executeUpdate();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		 return state;
	}
	public static List<Subject> getAllRecoredsByUsername(String username){  //Grades
		List<Subject> subjects = new ArrayList<Subject>();
	    try{  
	    	String sql = "SELECT subj.subjectID, subj.subjectName, subj.subjectCreditHours, subj.subjectLevel, subj.subjectPrerequisites, ss.subjectGrade\r\n"
	    			+ "FROM student_subjects ss\r\n"
	    			+ "JOIN subject subj ON ss.subjectID = subj.subjectID\r\n"
	    			+ "WHERE ss.studentUsername = ?;\r\n";
			Connection con = SubjectDao.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,username);  
	        ResultSet rs=preparedStatement.executeQuery();
	        while(rs.next()){  
	        	Subject subject = new Subject();  
	        	subject.setSubjectID(rs.getString("subjectID"));
	        	subject.setSubjectName(rs.getString("subjectName"));
	        	subject.setSubjectCreditHours(rs.getInt("subjectCreditHours"));
	        	subject.setSubjectLevel(rs.getString("subjectLevel"));
	        	subject.setSubjectPrerequisites(rs.getString("subjectPrerequisites"));
	        	subject.setSubjectGrade(rs.getString("subjectGrade"));
	        	subjects.add(subject);
	        }  
	    }
	    catch(SQLException e){
			e.printStackTrace(); 
	    }  
	    return subjects;
	   }
	public static List<Subject> getAllByUsername(String username){  //Registration
		List<Subject> subjects = new ArrayList<Subject>();
	    try{  
	    	String sql = "SELECT s.*\r\n"
	    			+ "FROM subject s\r\n"
	    			+ "LEFT JOIN student_subjects ss ON s.subjectID = ss.subjectID AND ss.studentUsername = ?\r\n"
	    			+ "LEFT JOIN registration_subject rs ON s.subjectID = rs.subjectID AND rs.studentUsername = ?\r\n"
	    			+ "WHERE ss.subjectID IS NULL AND rs.subjectID IS NULL;";
			Connection con = SubjectDao.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,username);  
			preparedStatement.setString(2,username);  
	        ResultSet rs=preparedStatement.executeQuery();
	        while(rs.next()){  
	        	Subject subject = new Subject();  
	        	subject.setSubjectID(rs.getString("subjectID"));
	        	subject.setSubjectName(rs.getString("subjectName"));
	        	subject.setSubjectCreditHours(rs.getInt("subjectCreditHours"));
	        	subject.setSubjectLevel(rs.getString("subjectLevel"));
	        	subject.setSubjectPrerequisites(rs.getString("subjectPrerequisites"));
	        	subjects.add(subject);
	        }  
	    }
	    catch(SQLException e){
			e.printStackTrace(); 
	    }  
	    return subjects;
	   }
	public static List<Subject> getAllRegisteredByUsername(String username){  //Registered
		List<Subject> subjects = new ArrayList<Subject>();
	    try{  
	    	String sql = "SELECT s.*\r\n"
	    			+ "FROM subject s\r\n"
	    			+ "LEFT JOIN registration_subject rs ON s.subjectID = rs.subjectID\r\n"
	    			+ "WHERE rs.studentUsername = ?";
			Connection con = SubjectDao.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,username);  
	        ResultSet rs=preparedStatement.executeQuery();
	        while(rs.next()){  
	        	Subject subject = new Subject();  
	        	subject.setSubjectID(rs.getString("subjectID"));
	        	subject.setSubjectName(rs.getString("subjectName"));
	        	subject.setSubjectCreditHours(rs.getInt("subjectCreditHours"));
	        	subject.setSubjectLevel(rs.getString("subjectLevel"));
	        	subject.setSubjectPrerequisites(rs.getString("subjectPrerequisites"));
	        	subjects.add(subject);
	        }  
	    }
	    catch(SQLException e){
			e.printStackTrace(); 
	    }  
	    return subjects;
	   }
}
