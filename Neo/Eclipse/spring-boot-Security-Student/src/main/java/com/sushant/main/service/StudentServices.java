package com.sushant.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.main.data.model.Project;
import com.sushant.main.data.model.Student;
import com.sushant.main.data.repository.StudentRepository;

@Service
public class StudentServices {

	private StudentRepository repo;
	private final ProjectServices projServices;
	
	@Autowired
	public StudentServices(StudentRepository repo, ProjectServices projServices) {	
		this.repo = repo;
		this.projServices = projServices;
	}

	public List<Student> listAll() {
		return (List<Student>) repo.findAll();
	}

	public Student getStudent(Integer id) {
		return repo.findById(id).get();
	}

	public Student save(Student student) {
		return repo.save(student);
		
	}
   public Student addProjectToStudent(Integer projId,Integer StudentId) {
	   Student student= getStudent(StudentId);
	   Project project=projServices.getProject(projId);
	   student.addProject(project);
	   return student;
   }
}
