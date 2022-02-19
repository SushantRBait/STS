package com.sushant.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sushant.main.model.Sim;

@Repository
public interface SimRepository extends JpaRepository<Sim, Long > {

}
