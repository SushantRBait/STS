package com.sushant.main.sim;

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

import com.sushant.main.customer.Customer;
import com.sushant.main.customer.CustomerRepository;

@RestController
@RequestMapping("/api/sim")
public class SimController {

	
	private final CustomerRepository customerRepository;
    private final SimRepository simRepository;

	@Autowired
    public SimController(CustomerRepository customerRepository, SimRepository simRepository) {
	
		this.customerRepository = customerRepository;
		this.simRepository = simRepository;
	}
    
    
	 @PostMapping("/add")
	    public ResponseEntity<Sim> create(@RequestBody  Sim sim) {
	        Optional<Customer> optionalCustomer= customerRepository.findById(sim.getCustomer().getCustId()); 
	        if (!optionalCustomer.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }

	        sim.setCustomer(optionalCustomer.get());

	        Sim savedSim = simRepository.save(sim);
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	            .buildAndExpand(savedSim.getSimno()).toUri();   

	        return ResponseEntity.created(location).body(savedSim);
	    }


	    @GetMapping("/getAll")
	    public ResponseEntity<Page<Sim>> getAll(Pageable pageable) {
	        return ResponseEntity.ok(simRepository.findAll(pageable));
	    }

	    @GetMapping("getById/{id}")
	    public ResponseEntity<Sim> getById(@PathVariable Integer id) {
	        Optional<Sim> optionalBook = simRepository.findById(id);
	        if (!optionalBook.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }

	        return ResponseEntity.ok(optionalBook.get());
	    }
	    
	    @DeleteMapping("/deleteById/{id}")
	    public ResponseEntity<Sim> delete(@PathVariable Integer id) {
	        Optional<Sim> optionalProject = simRepository.findById(id);
	        if (!optionalProject.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }

	        simRepository.delete(optionalProject.get());

	        return ResponseEntity.noContent().build();
	    }
	
}
