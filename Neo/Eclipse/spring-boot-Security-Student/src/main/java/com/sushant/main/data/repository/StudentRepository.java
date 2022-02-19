package com.sushant.main.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushant.main.data.model.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Integer> {

}
