package com.sushant.main.customer;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sushant.main.sim.SimRepository;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

	private final CustomerRepository customerRepository;
    private final SimRepository simRepository;
    
    @Autowired
	public CustomerController(CustomerRepository customerRepository, SimRepository simRepository) {
		this.customerRepository = customerRepository;
		this.simRepository = simRepository;
	}
    
    @PostMapping("/add")
    public ResponseEntity<Customer> create( @RequestBody Customer customer) {
    	Customer savedLCustomer = customerRepository.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedLCustomer.getCustId()).toUri();    

        return ResponseEntity.created(location).body(savedLCustomer);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Integer id) {
        Optional<Customer> optionalStudent = customerRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalStudent.get());
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Customer>> getAll(Pageable pageable) {
        return ResponseEntity.ok(customerRepository.findAll(pageable));
    }
   

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Integer id) {
        Optional<Customer> optionalCustomer= customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        customerRepository.delete(optionalCustomer.get());

        return ResponseEntity.noContent().build();
    }
}
