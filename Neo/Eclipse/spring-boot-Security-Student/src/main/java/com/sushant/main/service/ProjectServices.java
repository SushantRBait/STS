package com.sushant.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.main.data.model.Project;
import com.sushant.main.data.repository.ProjectRepository;

@Service
public class ProjectServices {

	private final ProjectRepository projRepo;

	@Autowired
	public ProjectServices(ProjectRepository projRepo) {
		this.projRepo = projRepo;
	}
     
	public List<Project> listAll() {
		return (List<Project>) projRepo.findAll();
	}
	
	@Transactional
	public Project getProject(Integer id) {
		return projRepo.findById(id).get();
	}
	
	@Transactional
	public Project save(Project project) {
		return projRepo.save(project);
	}

}
