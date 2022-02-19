package com.sushant.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushant.main.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findDepartmentById(Integer departmentId);

}
