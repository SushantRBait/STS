package com.sushant.main.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushant.main.data.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
