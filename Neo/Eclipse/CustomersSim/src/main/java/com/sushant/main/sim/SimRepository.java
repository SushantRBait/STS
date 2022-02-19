package com.sushant.main.sim;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimRepository extends JpaRepository<Sim,Integer> {

	//Optional<Sim> findById(Integer id);
}
