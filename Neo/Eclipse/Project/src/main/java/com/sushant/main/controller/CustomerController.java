package com.sushant.main.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sushant.main.model.Customer;
import com.sushant.main.model.Sim;
import com.sushant.main.repository.CustomerRepository;
import com.sushant.main.repository.SimRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/")
public class CustomerController {

	private final SimRepository simRepository;
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(SimRepository simRepository, CustomerRepository customerRepository) {
		super();
		this.simRepository = simRepository;
		this.customerRepository = customerRepository;
	}
	
	
	@GetMapping("customer/getAll")
    public ResponseEntity<Page<Customer>> getAll(Pageable pageable) {

		return ResponseEntity.ok(customerRepository.findAll(pageable));
    }
	
	
	@GetMapping("customer/getById/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Integer id) {
        Optional<Customer> optionalStudent = customerRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }	
	
	@PostMapping("customer/create")
    public ResponseEntity<Customer> createCustomer( @RequestBody Customer customer) {
    	Customer savedLCustomer = customerRepository.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedLCustomer.getCustId()).toUri();    

        return ResponseEntity.created(location).body(savedLCustomer);
    }
	
	@PostMapping("sim/create")
	public ResponseEntity<Sim> createSim(@RequestBody Sim sim) {
		Optional<Customer> optionalCustomer = customerRepository.findById(sim.getCustomer().getCustId());
		if (!optionalCustomer.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		sim.setCustomer(optionalCustomer.get());

		Sim savedSim = simRepository.save(sim);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSim.getSimId())
				.toUri();

		return ResponseEntity.created(location).body(savedSim);
	}
	
	@GetMapping("sim/getAll")
    public ResponseEntity<Page<Sim>> getAllSims(Pageable pageable) {
        return ResponseEntity.ok(simRepository.findAll(pageable));
    }

}
