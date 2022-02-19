package com.sushant.main.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sushant.main.data.model.dto.ProjectDto;

@Entity
@Table(name="Project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer Projid;
    private  String projname;
    private  Integer duration;
    @ManyToOne
    private Student student;
    
    public static Project from(ProjectDto projectdto) {
    	Project project=new Project();
    	project.setProjid(projectdto.getProjid());
    	project.setProjname(projectdto.getProjname());
    	project.setDuration(projectdto.getDuration());
    	return project;
    }
    
	public Project() {
		
	}

	public Project(Integer projid, String projname, Integer duration) {
		
		Projid = projid;
		this.projname = projname;
		this.duration = duration;
	}

	public Integer getProjid() {
		return Projid;
	}

	public String getProjname() {
		return projname;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setProjid(Integer projid) {
		Projid = projid;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
   
}
