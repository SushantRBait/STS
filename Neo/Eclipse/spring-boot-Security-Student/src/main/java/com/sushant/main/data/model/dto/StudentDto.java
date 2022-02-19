package com.sushant.main.data.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.sushant.main.data.model.Student;

public class StudentDto<Project> {

	private  Integer studentId;
    private  String studentFName;
    private  String studentLName;
    private  Long mobileNo;
    private  String email;
    private List<Project> projects=new ArrayList<>();
    
	public StudentDto() {
		
	}
    
    public static StudentDto from(Student student) {
    	StudentDto studentDto=new StudentDto();
    	studentDto.setStudentId(student.getStudentId());
    	studentDto.setStudentFName(student.getStudentFName());
    	studentDto.setStudentLName(student.getStudentLName());
    	studentDto.setMobileNo(student.getMobileNo());
    	studentDto.setEmail(student.getEmail());
    	studentDto.setProjects(student.getProject());
		return studentDto;
    	
    }

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentFName() {
		return studentFName;
	}

	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}

	public String getStudentLName() {
		return studentLName;
	}

	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
    
    
}
