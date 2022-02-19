package com.sushant.main.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.main.data.model.Project;
import com.sushant.main.data.model.dto.ProjectDto;
import com.sushant.main.service.ProjectServices;

@RestController
@RequestMapping("/Projects")
public class ProjectController {

		private final ProjectServices projectServices;
		
		@Autowired
		public ProjectController(ProjectServices projectServices) {
			this.projectServices = projectServices;
		}
		
		@PostMapping
		public ResponseEntity<ProjectDto> addProject(@RequestBody final ProjectDto projectdto) {
			Project project =projectServices.save(Project.from(projectdto));
			return new ResponseEntity<>(ProjectDto.from(project),HttpStatus.OK);
		}
		
		@GetMapping
		public ResponseEntity<List<ProjectDto>> getProjects() {
			List<Project> project=projectServices.listAll();
			List<ProjectDto> projectDto=project.stream().map(ProjectDto::from).collect(Collectors.toList());
			return new ResponseEntity<>(projectDto,HttpStatus.OK);	
		}
		
		@GetMapping(value="{proijid}")
		public ResponseEntity<ProjectDto> getProject(@PathVariable Integer proijid){
			Project project=projectServices.getProject(proijid);
			return new ResponseEntity<>(ProjectDto.from(project),HttpStatus.OK);			
		}
		
}
