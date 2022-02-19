package com.sushant.main.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sushant.main.data.model.dto.StudentDto;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer studentId;
    private  String studentFName;
    private  String studentLName;
    private  Long mobileNo;
    private  String email;
    
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="studentId")
    private  List<Project> projects=new ArrayList<>();
    
    public static Student from(StudentDto studentdto) {
        Student student=new Student();
        student.setStudentId(studentdto.getStudentId());
        student.setStudentFName(studentdto.getStudentFName());
        student.setStudentLName(studentdto.getStudentLName());
        student.setMobileNo(studentdto.getMobileNo());
        student.setEmail(studentdto.getEmail());
        student.setProject(studentdto.getProjects()); 
		return student;
  }
    
    public void addProject(Project project) {
    	projects.add(project);
    }
    public void removeProject(Project project) {
    	projects.remove(project);
    }

	public Student() {
		
	}

	public Student(Integer studentId, String studentFName, String studentLName, Long mobileNo, String email,
			List<Project> project) {
		this.studentId = studentId;
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.projects = project;
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

	public List<Project> getProject() {
		return projects;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}

	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProject(List<Project> project) {
		this.projects = project;
	}
	
    
    
}
