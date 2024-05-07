package com.student.information;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
	private String studentFirstName;
	private String studentLastName;
	private String studentLevel;
	private String studentUsername;
	private String studentPassword;
	private String studentEmail;
	private float studentCGPA;
	private String studentID;
	private int studentCreditHours;
	private int studentAge;
	public Student(){
		
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getStudentLevel() {
		return studentLevel;
	}
	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}
	public String getStudentUsername() {
		return studentUsername;
	}
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public float getStudentCGPA() {
		return studentCGPA;
	}
	public void setStudentCGPA(float studentCGPA) {
		this.studentCGPA = studentCGPA;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public int getStudentCreditHours() {
		return studentCreditHours;
	}
	public void setStudentCreditHours(int studentCreditHours) {
		this.studentCreditHours = studentCreditHours;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

}
