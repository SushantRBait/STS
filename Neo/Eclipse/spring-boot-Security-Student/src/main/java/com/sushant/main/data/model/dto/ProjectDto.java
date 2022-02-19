package com.sushant.main.data.model.dto;

import com.sushant.main.data.model.Project;

import lombok.Data;

@Data
public class ProjectDto {

	 private  Integer Projid;
	 private  String projname;
	 private  Integer duration;
	
	 public static ProjectDto from(Project project) {
		 ProjectDto projectDto=new ProjectDto();
		 projectDto.setProjid(project.getProjid());
		 
		 return projectDto;
		 
	 }
	 
	 public ProjectDto() {
		
	}

	public ProjectDto(Integer projid, String projname, Integer duration) {
		
		Projid = projid;
		this.projname = projname;
		this.duration = duration;
	}

	public Integer getProjid() {
		return Projid;
	}

	public void setProjid(Integer projid) {
		Projid = projid;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	    
}
