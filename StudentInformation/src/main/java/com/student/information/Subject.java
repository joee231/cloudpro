package com.student.information;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Subject implements Serializable{
	private String subjectID;
	private String subjectName;
	private int subjectCreditHours;
	private String subjectLevel;
	private String subjectPrerequisites;
	private String subjectGrade;
	public Subject() {
		
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectCreditHours() {
		return subjectCreditHours;
	}
	public void setSubjectCreditHours(int subjectCreditHours) {
		this.subjectCreditHours = subjectCreditHours;
	}
	public String getSubjectLevel() {
		return subjectLevel;
	}
	public void setSubjectLevel(String subjectLevel) {
		this.subjectLevel = subjectLevel;
	}
	public String getSubjectPrerequisites() {
		return subjectPrerequisites;
	}
	public void setSubjectPrerequisites(String subjectPrerequisites) {
		this.subjectPrerequisites = subjectPrerequisites;
	}
	public String getSubjectGrade() {
		return subjectGrade;
	}
	public void setSubjectGrade(String subjectGrade) {
		this.subjectGrade = subjectGrade;
	}
	
}
