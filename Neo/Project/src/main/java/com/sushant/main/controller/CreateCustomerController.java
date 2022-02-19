package com.sushant.main.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sushant.main.model.Customer;
import com.sushant.main.repository.CustomerRepository;
import com.sushant.main.repository.SimRepository;
@RestController
@RequestMapping("api/Customer")
public class CreateCustomerController {

	
	private final CustomerRepository customerRepository;
    private final SimRepository simRepository;
    
    @Autowired
	public CreateCustomerController(CustomerRepository customerRepository, SimRepository simRepository) {
		
    	this.customerRepository = customerRepository;
		this.simRepository = simRepository;
	}
    
    @PostMapping("/create")
    public ResponseEntity<Customer> create( @RequestBody Customer customer) {
    	Customer savedLCustomer = customerRepository.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedLCustomer.getCustId()).toUri();    

        return ResponseEntity.created(location).body(savedLCustomer);
    }

}
