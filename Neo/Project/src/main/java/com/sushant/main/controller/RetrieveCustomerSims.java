package com.sushant.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.main.model.Customer;
import com.sushant.main.repository.CustomerRepository;
import com.sushant.main.repository.SimRepository;

@RestController
@RequestMapping("api/customersims")
public class RetrieveCustomerSims {
	private final CustomerRepository customerRepository;
    private final SimRepository simRepository;
   
    @Autowired
   	public RetrieveCustomerSims(CustomerRepository customerRepository, SimRepository simRepository) {
   		super();
       	this.customerRepository = customerRepository;
   		this.simRepository = simRepository;
   	}
       
	@GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Integer id) {
        Optional<Customer> optionalCustomer= customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalCustomer.get());
    }
}