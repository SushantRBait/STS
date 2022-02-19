package com.sushant.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.main.model.Sim;
import com.sushant.main.repository.CustomerRepository;
import com.sushant.main.repository.SimRepository;

@RestController
@RequestMapping("api/Retrive")
public class RetriveAllSim {
	
    private final SimRepository simRepository;
   
    @Autowired
   	public RetriveAllSim(SimRepository simRepository) {
   		this.simRepository = simRepository;
   	}
	@GetMapping("/AllSim")
    public ResponseEntity<Page<Sim>> getAll(Pageable pageable) {
        return ResponseEntity.ok(simRepository.findAll(pageable));
    }
}
