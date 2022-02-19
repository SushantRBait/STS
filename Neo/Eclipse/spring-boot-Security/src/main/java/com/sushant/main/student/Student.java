package com.sushant.main.student;

public class Student {
	 private final Integer studentId;
     private final String studentFName;
     private final String studentLName;
     private final Long mobileNo;
     private final String email;
     
     
     
	public Student(Integer studentId, String studentFName, String studentLName, Long mobileNo, String email) {
		
		this.studentId = studentId;
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public String getStudentFName() {
		return studentFName;
	}
	public String getStudentLName() {
		return studentLName;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFName=" + studentFName + ", studentLName=" + studentLName
				+ ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}
	
	
}
